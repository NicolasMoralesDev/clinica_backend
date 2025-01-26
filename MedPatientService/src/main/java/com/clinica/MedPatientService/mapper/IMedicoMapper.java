package com.clinica.MedPatientService.mapper;

import com.clinica.MedPatientService.dto.MedicoDTO;
import com.clinica.MedPatientService.dto.PacienteDTO;
import com.clinica.MedPatientService.entity.Medico;
import com.clinica.MedPatientService.entity.Paciente;

public interface IMedicoMapper {

    Medico medicoDtoAMedico(MedicoDTO medicoDTO);

}
