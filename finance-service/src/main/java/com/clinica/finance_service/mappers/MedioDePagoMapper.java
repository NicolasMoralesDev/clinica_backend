package com.clinica.finance_service.mappers;

import com.clinica.finance_service.dto.MedioDePagoDTO;
import com.clinica.finance_service.modelo.MedioDePago;
import org.springframework.stereotype.Component;

@Component
public class MedioDePagoMapper {

    public MedioDePago toEntity(MedioDePagoDTO dto){
        return MedioDePago.builder()
                .nombre(dto.getNombre())
                .incremento(dto.getIncremento())
                .borrado(false)
                .build();
    }

}
