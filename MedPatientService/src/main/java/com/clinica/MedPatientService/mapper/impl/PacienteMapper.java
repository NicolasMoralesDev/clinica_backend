package com.clinica.MedPatientService.mapper.impl;

import com.clinica.MedPatientService.dto.PacienteDTO;
import com.clinica.MedPatientService.entity.Paciente;
import com.clinica.MedPatientService.mapper.IPacienteMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper implements IPacienteMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Paciente pacienteDtoAPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = modelMapper.map(pacienteDTO, Paciente.class);
        return paciente;
    }

}
