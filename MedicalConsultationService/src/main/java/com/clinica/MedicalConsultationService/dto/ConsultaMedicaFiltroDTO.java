package com.clinica.MedicalConsultationService.dto;


import lombok.Data;

import java.time.LocalDate;

/**
 * Clase DTO para filtro de consultas Medicas
 */
@Data
public class ConsultaMedicaFiltroDTO {
    private Long paciente;
    private LocalDate fecha;
    private Long medico;
    private boolean abierta;
}
