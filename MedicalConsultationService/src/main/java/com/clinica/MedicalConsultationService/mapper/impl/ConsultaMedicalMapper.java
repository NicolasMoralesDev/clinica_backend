package com.clinica.MedicalConsultationService.mapper.impl;

import com.clinica.MedicalConsultationService.dto.ConsultaMedicaDTO;
import com.clinica.MedicalConsultationService.entity.ConsultaMedica;
import com.clinica.MedicalConsultationService.mapper.IConsultaMedicaMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ConsultaMedicalMapper implements IConsultaMedicaMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public ConsultaMedica consultaMedicaDtoAConsultaMedica(ConsultaMedicaDTO consultaMedicaDTO) {
        return modelMapper.map(consultaMedicaDTO, ConsultaMedica.class);
    }

    @Override
    public ConsultaMedicaDTO consultaMedicaAConsultaMedicaDto(ConsultaMedica consultaMedica) {
        ConsultaMedicaDTO consultaMedicaDTO = modelMapper.map(ConsultaMedica.class, ConsultaMedicaDTO.class);
        consultaMedicaDTO.setId(consultaMedicaDTO.getId());
        return consultaMedicaDTO;
    }
}
