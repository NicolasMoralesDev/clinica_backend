package com.clinica.finance_service.servicio;

import com.clinica.finance_service.dto.FacturaDTO;
import com.clinica.finance_service.dto.FacturaDetalleDTO;
import com.clinica.finance_service.Excepciones.FacturaNoEncontradaExcepcion;
import com.clinica.finance_service.Excepciones.MedioDePagoNoEncontradoExcepcion;
import com.clinica.finance_service.Excepciones.TipoFacturaNoEncontradoExcepcion;
import com.clinica.finance_service.modelo.Factura;
import com.clinica.finance_service.modelo.FacturaDetalle;
import com.clinica.finance_service.modelo.MedioDePago;
import com.clinica.finance_service.modelo.TipoFactura;
import com.clinica.finance_service.repositorio.FacturaDetalleRepositorio;
import com.clinica.finance_service.repositorio.FacturaRepositorio;
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
        MedioDePago medioDePago = medioDePagoServicio.obtenerPorId(dto.getMedioDePago());

        if(tipoFactura == null) throw new TipoFacturaNoEncontradoExcepcion("La factura no existe");
        if(medioDePago == null) throw new MedioDePagoNoEncontradoExcepcion("El medio de pago no existe");

        Factura factura = new Factura();
        factura.setPagado(true);
        factura.setFechaEmision(LocalDate.now());
        factura.setTipoFactura(tipoFactura);
        factura.setIdPaciente(dto.getIdPaciente());
        factura.setMedioDePago(medioDePago);
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
            detalle.setPrecio(12590.00); // PENDIENTE PERSISTIR EL PRECIO DEL TURNO OBTENIDO DEL MICROSERVICIO TURNOS
            detalle.setBorrado(false);
            detalleList.add(detalle);
            total += 12590.00; //PENDIENTE PERSISTIR LA SUMATORIA DEL PRECIO DE LOS TURNOS OBTENIDO DEL MICROSERVICIO TURNOS
        }

        //Guardo los detalles en la base de datos
        facturaDetalleRepositorio.saveAll(detalleList);

        factura.setTotal(total);
        return facturaRepositorio.save(factura);
    }

    @Override
    public Factura actualizar(Long id, FacturaDTO dto) {
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
}
