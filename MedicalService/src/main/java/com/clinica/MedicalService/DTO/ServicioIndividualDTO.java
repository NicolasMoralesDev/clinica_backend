package com.clinica.MedicalService.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServicioIndividualDTO {

    private String nombre;
    private String descripcion;
    private Double precio;
    private String codigo;
    private Long categoria;

}
