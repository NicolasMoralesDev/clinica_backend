package com.clinica.MedPatientService.mapper.impl;

import com.clinica.MedPatientService.dto.MedicoDTO;
import com.clinica.MedPatientService.entity.Medico;
import com.clinica.MedPatientService.mapper.IMedicoMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MedicoMapper implements IMedicoMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Medico medicoDtoAMedico(MedicoDTO medicoDTO) {
        Medico medico = modelMapper.map(medicoDTO, Medico.class);
        return medico;
    }
}
