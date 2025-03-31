package com.clinica.MedPatientService.mapper.impl;

import com.clinica.MedPatientService.dto.EspecialidadDTO;
import com.clinica.MedPatientService.entity.Especialidad;
import com.clinica.MedPatientService.mapper.IEspecialidadMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EspecialidadMapper implements IEspecialidadMapper  {

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Especialidad especialidadDtoAEspecialidad(EspecialidadDTO especialidadDTO) {
        Especialidad especialidad = modelMapper.map(especialidadDTO, Especialidad.class);
        return especialidad;
    }
}
