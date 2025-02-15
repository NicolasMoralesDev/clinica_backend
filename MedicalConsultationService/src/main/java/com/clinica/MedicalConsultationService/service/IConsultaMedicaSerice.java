package com.clinica.MedicalConsultationService.service;

import com.clinica.MedicalConsultationService.dto.ConsultaMedicaDTO;
import com.clinica.MedicalConsultationService.entity.ConsultaMedica;

import java.util.List;

public interface IConsultaMedicaSerice {

    List<ConsultaMedicaDTO> obtenerTodos() throws Exception;
    ConsultaMedica obtenerPorId(Long id) throws Exception;
    ConsultaMedica crear(ConsultaMedicaDTO consultaMedicaDTO) throws Exception;
    ConsultaMedica actualizar(ConsultaMedicaDTO consultaMedicaDTO) throws Exception;
    void eliminar(List<Long> ids) throws Exception;
}
