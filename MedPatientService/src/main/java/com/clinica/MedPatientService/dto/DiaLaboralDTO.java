package com.clinica.MedPatientService.dto;

import lombok.Data;

/**
 * Clase DTO de DiasLaborales
 */
@Data
public class DiaLaboralDTO {
    private Long id;
    private MedicoDTO medico;
    private int turnosDisponibles;
    private String fecha;
    private String horarioInicio;
    private boolean borrado;
}
