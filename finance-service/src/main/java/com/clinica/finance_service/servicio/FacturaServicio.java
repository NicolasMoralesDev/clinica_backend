package com.clinica.finance_service.servicio;

import com.clinica.finance_service.DTO.*;
import com.clinica.finance_service.Excepciones.FacturaBorradaExcepcion;
import com.clinica.finance_service.Excepciones.FacturaPagadaExcepcion;
import com.clinica.finance_service.Excepciones.FacturaNoEncontradaExcepcion;
import com.clinica.finance_service.Excepciones.TipoFacturaNoEncontradoExcepcion;
import com.clinica.finance_service.modelo.Factura;
import com.clinica.finance_service.modelo.FacturaDetalle;
import com.clinica.finance_service.modelo.TipoFactura;
import com.clinica.finance_service.repositorio.*;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FacturaServicio implements IFacturaServicio{

    private final FacturaRepositorio facturaRepositorio;
    private final FacturaDetalleRepositorio facturaDetalleRepositorio;
    private final TipoFacturaServicio tipoFacturaServicio;

    private final ITurnosAPI iTurnosAPI;
    private final IPacientesAPI iPacientesAPI;
    private final IServicioMedicoAPI iServicioMedicoAPI;

    @Override
    @Transactional(readOnly = true)
    public List<Factura> listarTodos() {
        return facturaRepositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Factura obtenerPorId(Long id) {
        return facturaRepositorio.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Factura crear(FacturaDTO dto) {
        TipoFactura tipoFactura = tipoFacturaServicio.obtenerPorId(dto.getTipoFactura());
        if(tipoFactura == null) throw new TipoFacturaNoEncontradoExcepcion("La factura no existe");

        //Obtengo el paciente para verificar si cuenta con obra social
        PacienteDTO paciente = obtenerPaciente(dto.getIdPaciente());

        Factura factura = new Factura();
        factura.setPagado(false);
        factura.setFechaEmision(LocalDate.now());
        factura.setTipoFactura(tipoFactura);
        factura.setIdPaciente(dto.getIdPaciente());
        factura.setBorrado(false);
        facturaRepositorio.save(factura);

        double total = 0D;
        //Proceso los detalles
        List<FacturaDetalle> detalleList = new ArrayList<>();
        for(FacturaDetalleDTO detalleDTO : dto.getDetalles()){

            //Obtengo el turno de la api de turnos para obtener el precio
            ConsultaMedicaDTO turno = obtenerConsultaMedica(detalleDTO.getIdTurno());
            ServicioMedico servicio = iServicioMedicoAPI.getById(turno.getServicioIndividual());

            System.out.println("----");
            System.out.println(servicio);

            FacturaDetalle detalle = new FacturaDetalle();
            detalle.setFactura(factura);
            detalle.setIdTurno(turno.getId());
            //Realizo el descuento del 20% en casi de tener obraSocial
            if(paciente.isObraSocial()) detalle.setPrecio(servicio.getPrecio() * 0.80 );
            else detalle.setPrecio(servicio.getPrecio());
            detalle.setBorrado(false);
            detalleList.add(detalle);
            //Actualizo el total de los detalles para luego persistirlo en la factura
            total += detalle.getPrecio();
        }

        //Guardo los detalles en la base de datos
        facturaDetalleRepositorio.saveAll(detalleList);

        factura.setTotal(total);
        return facturaRepositorio.save(factura);
    }

    /**
     * <p>Este metodo actualiza los atributos {@link TipoFactura}, idPaciente y la lista de {@link FacturaDetalle} validando antes,
     * que la factura exista y no se encuentre pagada, modificando unicamente los campos recibidos y que hayan
     * cambiado en el DTO<p/>
     * @param id Long
     * @param dto {@link FacturaDTO}
     * @return
     */
    @Override
    @Transactional
    public Factura actualizar(Long id, FacturaDTO dto) {
        Factura factura = this.obtenerPorId(id);
        if(factura == null) throw new FacturaNoEncontradaExcepcion("La factura no existe");
        if(factura.getPagado()) throw new FacturaPagadaExcepcion();
        if(factura.getBorrado()) throw new FacturaBorradaExcepcion();

        //Si recibo la factura y cambia en relacion al registro de la BD, actualizo el atributo
        if(dto.getTipoFactura() != null && dto.getTipoFactura() != factura.getTipoFactura().getIdTipoFactura()){
            TipoFactura tipoFactura = tipoFacturaServicio.obtenerPorId(dto.getTipoFactura());
            if(tipoFactura == null) throw new TipoFacturaNoEncontradoExcepcion("El tipo factura no existe");
            factura.setTipoFactura(tipoFactura);
        }

        //Si recibo el idPaciente y cambia en relacion al registro de la BD, actualizo el atributo
        if(dto.getIdPaciente() != null && dto.getIdPaciente() !=
                factura.getIdFactura()) factura.setIdPaciente(dto.getIdPaciente());

        //Actualizacion de detalles
        List<FacturaDetalle> detallesActuales = facturaDetalleRepositorio.findByFactura(factura);

        List<Long> idsTurnosDetallesActuales = detallesActuales.stream().map(FacturaDetalle::getIdTurno).toList();
        List<Long> idsTurnosDetallesDTO = dto.getDetalles().stream().map(FacturaDetalleDTO::getIdTurno).toList();

        List<FacturaDetalle> detallesAEliminar = detallesActuales.stream()
                .filter(item -> !idsTurnosDetallesDTO.contains(item.getIdTurno())).toList();
        facturaDetalleRepositorio.deleteAll(detallesAEliminar);

        //Agregamos los nuevos detalles
        List<FacturaDetalle> detallesAgregar = new ArrayList<>();

        System.out.println("FacturaDetallesDTO: " + dto.getDetalles());
        for (FacturaDetalleDTO item : dto.getDetalles()){
            System.out.println("Verificando el turno: " + item.getIdTurno());
            if(!idsTurnosDetallesActuales.contains(item.getIdTurno())){
                System.out.println("Nuevo turno detectado: " + item.getIdTurno());
                FacturaDetalle facturaDetalle = new FacturaDetalle();
                facturaDetalle.setFactura(factura);
                facturaDetalle.setIdTurno(item.getIdTurno());
                facturaDetalle.setPrecio(12500D); // OBTENER PRECIO DEL TURNO DEL MICROSERV TURNOS
                facturaDetalle.setBorrado(false);
                detallesAgregar.add(facturaDetalle);
            }else{
                System.out.println("El turno" + item.getIdTurno() + " ya existe.");
            }

            facturaDetalleRepositorio.saveAll(detallesAgregar);

            //Recalculamos el total
            Double total = facturaDetalleRepositorio.findByFactura(factura).stream()
                    .mapToDouble(FacturaDetalle::getPrecio).sum();
            factura.setTotal(total);
        }

        return factura;
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Factura factura = this.obtenerPorId(id);
        if(factura == null) throw new FacturaNoEncontradaExcepcion("La factura no existe");
        if(factura.getPagado()) throw new FacturaPagadaExcepcion();

        factura.setBorrado(true);
        factura.getDetalles().forEach( detalle -> detalle.setBorrado(true));
        facturaDetalleRepositorio.saveAll(factura.getDetalles());
    }

    @Override
    @Transactional
    public void bloquearFactura(Long idFactura) {
        Factura factura = this.obtenerPorId(idFactura);
        if(factura == null) throw new FacturaNoEncontradaExcepcion("La factura no existe");
        factura.setPagado(true);
    }


    @CircuitBreaker(name = "MedicalConsultationService", fallbackMethod = "fallbackMedicalConsultationService")
    @Retry(name = "MedicalConsultationService")
    public ConsultaMedicaDTO obtenerConsultaMedica(Long idTurno){
        ConsultaMedicaDTO turno = iTurnosAPI.getConsultasMedicasPorId(idTurno);
        return turno;
    }



    @CircuitBreaker(name = "MedPatientService", fallbackMethod = "fallbackMedPatientService")
    @Retry(name = "MedPatientService")
    public PacienteDTO obtenerPaciente(Long idPaciente){
        PacienteDTO paciente = iPacientesAPI.getPacienteById(idPaciente);
        return paciente;
    }

    public ConsultaMedicaDTO fallbackMedicalConsultationService(Long idTurno, Throwable t){
        return new ConsultaMedicaDTO();
    }

    public PacienteDTO fallbackMedPatientService(Long idPaciente, Throwable t){
        return new PacienteDTO();
    }

}
