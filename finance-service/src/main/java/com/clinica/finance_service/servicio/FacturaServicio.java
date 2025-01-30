package com.clinica.finance_service.servicio;

import com.clinica.finance_service.DTO.FacturaDTO;
import com.clinica.finance_service.DTO.FacturaDetalleDTO;
import com.clinica.finance_service.Excepciones.FacturaPagadaExcepcion;
import com.clinica.finance_service.Excepciones.FacturaNoEncontradaExcepcion;
import com.clinica.finance_service.Excepciones.TipoFacturaNoEncontradoExcepcion;
import com.clinica.finance_service.modelo.Factura;
import com.clinica.finance_service.modelo.FacturaDetalle;
import com.clinica.finance_service.modelo.TipoFactura;
import com.clinica.finance_service.repositorio.FacturaDetalleRepositorio;
import com.clinica.finance_service.repositorio.FacturaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FacturaServicio implements IFacturaServicio{

    private final FacturaRepositorio facturaRepositorio;
    private final FacturaDetalleRepositorio facturaDetalleRepositorio;
    private final TipoFacturaServicio tipoFacturaServicio;
    private final MedioDePagoServicio medioDePagoServicio;

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

        Factura factura = new Factura();
        factura.setPagado(false);
        factura.setFechaEmision(LocalDate.now());
        factura.setTipoFactura(tipoFactura);
        factura.setIdPaciente(dto.getIdPaciente());
        facturaRepositorio.save(factura);

        Double total = 0D;
        //Proceso los detalles
        List<FacturaDetalle> detalleList = new ArrayList<>();
        for(FacturaDetalleDTO detalleDTO : dto.getDetalles()){
            //Obtengo el turno de la api de turnos
//            TurnoDTO turno = turnoApi.obtenerPorId(detalleDTO.getIdTurno());

            FacturaDetalle detalle = new FacturaDetalle();
            detalle.setFactura(factura);
            detalle.setIdTurno(1L); // PENDIENTE PERSISTIR EL ID DEL TURNO OBTENIDO DEL MICROSERVICIO TURNOS
            detalle.setPrecio(12590.00); // PENDIENTE PERSISTIR EL PRECIO DEL TURNO OBTENIDO DEL MICROSERVICIO TURNOS --> HACER DESCUENTO EN CASO DE TENER OBRA SOCIAL
            detalle.setBorrado(false);
            detalleList.add(detalle);
            total += 12590.00; //PENDIENTE PERSISTIR LA SUMATORIA DEL PRECIO DE LOS TURNOS OBTENIDO DEL MICROSERVICIO TURNOS
        }

        //Guardo los detalles en la base de datos
        facturaDetalleRepositorio.saveAll(detalleList);

        factura.setTotal(total);
        return facturaRepositorio.save(factura);
    }

    /**
     * <p>Este metodo actualiza los atributos {@link TipoFactura} e idPaciente validando antes,
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

        //Si recibo la factura y cambia en relacion al registro de la BD, actualizo el atributo
        if(dto.getTipoFactura() != null && dto.getTipoFactura() != factura.getTipoFactura().getIdTipoFactura()){
            TipoFactura tipoFactura = tipoFacturaServicio.obtenerPorId(dto.getTipoFactura());
            if(tipoFactura == null) throw new TipoFacturaNoEncontradoExcepcion("El tipo factura no existe");
            factura.setTipoFactura(tipoFactura);
        }

        //Si recibo la el idPaciente y cambia en relacion al registro de la BD, actualizo el atributo
        if(dto.getIdPaciente() != null && dto.getIdPaciente() !=
                factura.getIdFactura()) factura.setIdPaciente(dto.getIdPaciente());


        //PENDIENTE DE IMPLEMENTAR ACTUALIZACION DE DETALLES DONDE CADA DETALLE VAN A SER ITEMS DE LA CLASE ConsultaMedica
        //La logica consiste en que se podran agregar o quitar registros FacturaDetalle, que hacen referncia a los objetos de ConsultaMedica

        return null;
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Factura factura = this.obtenerPorId(id);
        if(factura == null) throw new FacturaNoEncontradaExcepcion("La factura no existe");
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
}
