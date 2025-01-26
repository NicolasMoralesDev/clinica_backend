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
    private int horarioInicio;
    private boolean borrado;
}
