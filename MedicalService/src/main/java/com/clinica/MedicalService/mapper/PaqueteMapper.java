package com.clinica.MedicalService.mapper;

import com.clinica.MedicalService.DTO.PaqueteDTO;
import com.clinica.MedicalService.modelo.Paquete;
import com.clinica.MedicalService.modelo.ServicioIndividual;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaqueteMapper {

    public Paquete toEntity(PaqueteDTO paqueteDTO, List<ServicioIndividual> servicios){
        return Paquete.builder()
                .nombre(paqueteDTO.getNombre())
                .descripcion(paqueteDTO.getDescripcion())
                .codigo(paqueteDTO.getCodigo())
                .servicios(servicios)
                .borrado(false)
                .build();
    }


}
