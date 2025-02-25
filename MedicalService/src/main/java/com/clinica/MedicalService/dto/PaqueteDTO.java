package com.clinica.MedicalService.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaqueteDTO {

    private String nombre;
    private String descripcion;
    private String codigo;
    private List<Long> servicios;

}
