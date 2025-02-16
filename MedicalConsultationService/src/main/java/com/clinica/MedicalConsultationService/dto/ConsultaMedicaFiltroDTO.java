package com.clinica.MedicalConsultationService.dto;


import lombok.Data;

/**
 * Clase DTO para filtro de consultas Medicas
 */
@Data
public class ConsultaMedicaFiltroDTO {

    private Long paciente;
    private Long medico;
    private boolean abierta;
}
