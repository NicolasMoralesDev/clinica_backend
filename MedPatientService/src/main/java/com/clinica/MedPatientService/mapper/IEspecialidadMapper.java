package com.clinica.MedPatientService.mapper;

import com.clinica.MedPatientService.dto.EspecialidadDTO;
import com.clinica.MedPatientService.entity.Especialidad;

public interface IEspecialidadMapper {

    Especialidad especialidadDtoAEspecialidad(EspecialidadDTO especialidadDTO);
}
