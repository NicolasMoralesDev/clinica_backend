package com.clinica.finance_service.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicioIndividual extends ServicioMedico {

    private CategoriaDTO categoria;

}
