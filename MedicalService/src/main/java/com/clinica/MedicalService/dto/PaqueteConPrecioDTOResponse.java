package com.clinica.MedicalService.DTO;

import com.clinica.MedicalService.modelo.ServicioIndividual;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaqueteConPrecioDTOResponse {

    private String nombre;
    private String descripcion;
    private String codigo;
    private List<ServicioIndividual> servicios;
    private Double precio;
}
