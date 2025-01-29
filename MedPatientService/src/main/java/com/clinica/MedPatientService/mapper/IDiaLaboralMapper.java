package com.clinica.MedPatientService.mapper;

import com.clinica.MedPatientService.dto.DiaLaboralDTO;
import com.clinica.MedPatientService.entity.DiaLaboral;

public interface IDiaLaboralMapper {

    DiaLaboral diaLaboralDtoADiasLaboral(DiaLaboralDTO diaLaboralDTO);

}
