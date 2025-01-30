package com.clinica.finance_service.servicio;

import com.clinica.finance_service.DTO.CobroDTO;
import com.clinica.finance_service.Excepciones.*;
import com.clinica.finance_service.Mappers.CobroMapper;
import com.clinica.finance_service.modelo.Cobro;
import com.clinica.finance_service.modelo.Factura;
import com.clinica.finance_service.modelo.MedioDePago;
import com.clinica.finance_service.repositorio.CobroRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CobroServicio implements ICobroServicio {

    private final CobroRepositorio cobroRepositorio;
    private final FacturaServicio facturaServicio;
    private final MedioDePagoServicio medioDePagoServicio;
    private final CobroMapper cobroMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Cobro> listarTodos() {
        return cobroRepositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cobro obtenerPorId(Long id) {
        return cobroRepositorio.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cobro crear(CobroDTO dto) {
        Factura factura = facturaServicio.obtenerPorId(dto.getFactura());

        if(factura == null) throw new FacturaNoEncontradaExcepcion("La factura no existe");
        if(factura.getPagado()) throw new FacturaPagadaExcepcion();
        MedioDePago medioDePago = medioDePagoServicio.obtenerPorId(dto.getMedioDePago());
        if(medioDePago == null) throw new MedioDePagoNoEncontradoExcepcion("El medio de pago no existe");

        Cobro cobro = cobroMapper.toEntity(dto, factura, medioDePago);
        return cobroRepositorio.save(cobro);
    }

    @Override
    @Transactional
    public Cobro actualizar(Long id,  CobroDTO dto) {
        Cobro cobro = this.obtenerPorId(id);
        if(cobro == null) throw new CobroNoEncontradoExcepcion();
        if(cobro.getBloqueado()) throw new CobroBloqueadoExcepcion();

        MedioDePago medioDePago = medioDePagoServicio.obtenerPorId(dto.getMedioDePago());
        if(medioDePago == null) throw new MedioDePagoNoEncontradoExcepcion("El medio de pago no existe");
        cobro.setMedioDePago(medioDePago);

        if(cobro.getMonto() != null && cobro.getMonto() != dto.getMonto()) cobro.setMonto(dto.getMonto());

        return cobro;
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Cobro cobro = this.obtenerPorId(id);
        if(cobro == null) throw new CobroNoEncontradoExcepcion();
        cobro.setBorrado(true);
    }

    /**
     * <p>Este metodo se encarga de marcar la {@link Factura} como pagada y
     * los cobros vinculados a la misma, en caso de que el paciente haya abonado la totalidad del servicio</p>
     * @param idFactura
     * @return
     */
    @Override
    @Transactional
    public List<Cobro> bloquearCobros(Long idFactura) {
        Factura factura = facturaServicio.obtenerPorId(idFactura);
        if(factura == null) throw new FacturaNoEncontradaExcepcion("La factura no existe");

        List<Cobro> cobroList = cobroRepositorio.findByFactura(factura);

        double totalFactura = factura.getTotal();
        double totalEntregas = 0;

        // Recorro la lista de cobros para verificar si el paciente pago la totalidad de la factura o no
        for (Cobro item: cobroList) {
            totalEntregas+= item.getMonto();
        }

        if(totalEntregas >= totalFactura){
            //Vuelvo a recorrer las items de cobros para bloquearlos
            for (Cobro item: cobroList) {
                item.setBloqueado(true);
            }
            facturaServicio.bloquearFactura(idFactura);
        }


        return cobroList;
    }
}
