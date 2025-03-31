package com.clinica.MedicalConsultationService.dto;

import lombok.Data;

/**
 * Clase DTO de Paciente
 */
@Data
public class PacienteDTO {

    private Long id;
    private String nombre;
    private boolean obraSocial;
    private String dni;
    private String direccion;
    private String email;
}
