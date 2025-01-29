package com.clinica.MedPatientService.dto;

import com.clinica.MedPatientService.dto.base.PersonaDTO;
import lombok.Data;

import java.util.Set;

/**
 * Clase DTO de Pacientes
 */
@Data
public class PacienteDTO extends PersonaDTO {
    private Set<EnfermedadDTO> enfermedades;
}
