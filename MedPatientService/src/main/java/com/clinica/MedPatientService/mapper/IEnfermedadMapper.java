package com.clinica.MedPatientService.mapper;

import com.clinica.MedPatientService.dto.EnfermedadDTO;
import com.clinica.MedPatientService.entity.Enfermedad;

public interface IEnfermedadMapper {

    Enfermedad enfermedadDtoAEnfermedad(EnfermedadDTO enfermedadDTO);

}
