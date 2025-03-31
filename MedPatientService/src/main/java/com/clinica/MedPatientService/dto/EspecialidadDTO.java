package com.clinica.MedPatientService.dto;

import lombok.Data;

/**
 * Clase DTO de Especialidades
 */
@Data
public class EspecialidadDTO {
    private Long id;
    private String nombre;
    private boolean borrado;
}
