package com.clinica.MedPatientService.dto;

import com.clinica.MedPatientService.dto.base.PersonaDTO;
import lombok.Data;

import java.util.Set;

/**
 * Clase DTO de Medicos
 */
@Data
public class MedicoDTO extends PersonaDTO {
    private double sueldo;
    private EspecialidadDTO especialidad;
    private Set<DiaLaboralDTO> diasLaborales;
}
