package com.clinica.MedicalService.mapper;

import com.clinica.MedicalService.DTO.CategoriaDTO;
import com.clinica.MedicalService.modelo.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public Categoria toEntity(CategoriaDTO dto){
        return Categoria.builder()
                .nombre(dto.getNombre())
                .codigoCategoria(dto.getCodigoCategoria())
                .borrado(false)
                .build();
    }

}
