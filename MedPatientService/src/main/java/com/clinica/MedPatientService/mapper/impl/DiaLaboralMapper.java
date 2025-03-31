package com.clinica.MedPatientService.mapper.impl;

import com.clinica.MedPatientService.dto.DiaLaboralDTO;
import com.clinica.MedPatientService.entity.DiaLaboral;
import com.clinica.MedPatientService.mapper.IDiaLaboralMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DiaLaboralMapper implements IDiaLaboralMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public DiaLaboral diaLaboralDtoADiasLaboral(DiaLaboralDTO diaLaboralDTO) {
        DiaLaboral diaLaboral = modelMapper.map(diaLaboralDTO, DiaLaboral.class);
        return diaLaboral;
    }
}
