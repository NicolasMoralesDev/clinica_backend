package com.clinica.MedPatientService.dto;

import lombok.Data;

/**
 * Clase DTO del Buscar turnos disponibles
 */
@Data
public class BuscarTurnoDTO {
    private Long idMedico;
    private String fecha;
}
