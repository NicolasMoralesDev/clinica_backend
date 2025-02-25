package com.clinica.MedPatientService.dto.base;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonaDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private Long dni;
    private String email;
    private LocalDate fechaNacimiento;
    private String telefono;
}
