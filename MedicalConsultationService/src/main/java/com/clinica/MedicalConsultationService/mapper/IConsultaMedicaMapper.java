package com.clinica.MedicalConsultationService.mapper;

import com.clinica.MedicalConsultationService.dto.ConsultaMedicaDTO;
import com.clinica.MedicalConsultationService.entity.ConsultaMedica;

public interface IConsultaMedicaMapper {

    ConsultaMedica consultaMedicaDtoAConsultaMedica(ConsultaMedicaDTO consultaMedicaDTO);

}
