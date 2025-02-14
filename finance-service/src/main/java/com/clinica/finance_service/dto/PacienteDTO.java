package com.clinica.finance_service.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private Long dni;
    private String email;
    private LocalDate fechaNac;
    private String telefono;
    private String direccion;
    private boolean activo;
    private boolean obraSocial;

}
