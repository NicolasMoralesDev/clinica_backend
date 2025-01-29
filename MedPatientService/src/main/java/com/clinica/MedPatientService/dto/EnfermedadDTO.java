package com.clinica.MedPatientService.dto;

import lombok.Data;

/**
 * Clase DTO de Enfermedades
 */
@Data
public class EnfermedadDTO {
    private Long id;
    private String nombre;
    private boolean borrado;
}
