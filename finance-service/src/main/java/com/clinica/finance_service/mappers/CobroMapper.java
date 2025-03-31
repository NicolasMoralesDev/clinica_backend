package com.clinica.finance_service.mappers;

import com.clinica.finance_service.dto.CobroDTO;
import com.clinica.finance_service.modelo.Cobro;
import com.clinica.finance_service.modelo.Factura;
import com.clinica.finance_service.modelo.MedioDePago;
import org.springframework.stereotype.Component;

@Component
public class CobroMapper {

    public Cobro toEntity(CobroDTO dto, Factura factura, MedioDePago medioDePago){
        return Cobro.builder()
                .factura(factura)
                .medioDePago(medioDePago)
                .monto(dto.getMonto())
                .bloqueado(false)
                .borrado(false)
                .build();
    }


}
