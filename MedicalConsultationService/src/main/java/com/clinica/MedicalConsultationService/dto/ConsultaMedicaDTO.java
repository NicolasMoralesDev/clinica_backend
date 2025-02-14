package com.clinica.MedicalConsultationService.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase DTO de ConsultaMedica
 */
@Data
public class ConsultaMedicaDTO {

    private Long id;
    private LocalDate fechaTurno;
    private LocalTime horaTurno;
    private Long medico;
    private Long paciente;
    private Long servicioIndividual;
    private double montoTotal;
    private boolean pagado;
    private boolean borrado;
}
