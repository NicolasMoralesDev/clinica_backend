package com.clinica.MedPatientService.mapper;

import com.clinica.MedPatientService.dto.PacienteDTO;
import com.clinica.MedPatientService.entity.Paciente;

public interface IPacienteMapper {

    Paciente pacienteDtoAPaciente(PacienteDTO pacienteDTO);
}
