package com.clinica.MedPatientService.mapper.impl;

import com.clinica.MedPatientService.dto.EnfermedadDTO;
import com.clinica.MedPatientService.entity.Enfermedad;
import com.clinica.MedPatientService.mapper.IEnfermedadMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EnfermedadMapper implements IEnfermedadMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Enfermedad enfermedadDtoAEnfermedad(EnfermedadDTO enfermedadDTO) {
        Enfermedad enfermedad = modelMapper.map(enfermedadDTO, Enfermedad.class);
        return enfermedad;
    }
}
