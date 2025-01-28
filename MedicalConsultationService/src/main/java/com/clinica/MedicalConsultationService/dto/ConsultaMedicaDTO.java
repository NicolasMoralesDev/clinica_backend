package com.clinica.MedicalConsultationService.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase DTO de ConsultaMedica
 */
@Data
public class ConsultaMedicaDTO {

    private LocalDate fechaTurno;
    private LocalTime horaTurno;
    private double montoTotal;
    private boolean pagado;
    private boolean borrado;
}
