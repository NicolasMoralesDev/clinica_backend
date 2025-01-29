package com.clinica.MedicalService.mapper;

import com.clinica.MedicalService.DTO.ServicioIndividualDTO;
import com.clinica.MedicalService.modelo.Categoria;
import com.clinica.MedicalService.modelo.ServicioIndividual;
import org.springframework.stereotype.Component;

@Component
public class ServicioIndividualMapper {

    public ServicioIndividual toEntity(ServicioIndividualDTO dto, Categoria categoria){
        return ServicioIndividual.builder()
                .nombre(dto.getNombre())
                .codigo(dto.getCodigo())
                .descripcion(dto.getDescripcion())
                .precio(dto.getPrecio())
                .categoria(categoria)
                .borrado(false)
                .build();
    }

}
