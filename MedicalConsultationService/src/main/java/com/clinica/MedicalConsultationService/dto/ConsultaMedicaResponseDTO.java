package com.clinica.MedicalConsultationService.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase DTO para response de filtro fechas turno
 */
@Data
public class ConsultaMedicaResponseDTO {
    private LocalTime horaTurno;
}
