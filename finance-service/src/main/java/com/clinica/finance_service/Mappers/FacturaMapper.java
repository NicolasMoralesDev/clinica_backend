package com.clinica.finance_service.Mappers;

import com.clinica.finance_service.DTO.FacturaDTO;
import com.clinica.finance_service.DTO.FacturaDetalleDTO;
import com.clinica.finance_service.modelo.Factura;
import com.clinica.finance_service.modelo.FacturaDetalle;
import com.clinica.finance_service.modelo.MedioDePago;
import com.clinica.finance_service.modelo.TipoFactura;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FacturaMapper {

    public Factura toEntity(FacturaDTO dto, List<FacturaDetalle> facturaDetalleList, TipoFactura tipoFactura, MedioDePago medioDePago){
        return Factura.builder()
                .tipoFactura(tipoFactura)
                .medioDePago(medioDePago)
                .detalles(facturaDetalleList)
                .borrado(false)
                .build();
    }

}
