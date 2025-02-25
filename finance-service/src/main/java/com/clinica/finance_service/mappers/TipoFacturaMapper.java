package com.clinica.finance_service.Mappers;

import com.clinica.finance_service.dto.TipoFacturaDTO;
import com.clinica.finance_service.modelo.TipoFactura;
import org.springframework.stereotype.Component;

@Component
public class TipoFacturaMapper {

    public  TipoFactura toEntity(TipoFacturaDTO dto){
        return TipoFactura.builder()
                .nombre(dto.getNombre())
                .borrado(false)
                .build();
    }

}
