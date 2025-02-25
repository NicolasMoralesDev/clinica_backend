package com.clinica.MedicalConsultationService.repository;

import com.clinica.MedicalConsultationService.dto.ConsultaMedicaFiltroDTO;
import com.clinica.MedicalConsultationService.dto.ConsultasMedicasParametroDTO;
import com.clinica.MedicalConsultationService.entity.ConsultaMedica;

import java.util.List;

public interface IConsultaMedicaFiltroRepository {

    List<ConsultaMedica> findByFilter(ConsultaMedicaFiltroDTO consultaMedicaFiltro);
    ConsultaMedica findByParameter(ConsultasMedicasParametroDTO consultasMedicasParametroDTO);
}
