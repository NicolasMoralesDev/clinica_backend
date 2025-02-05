package com.clinica.finance_service.DTO;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Paquete extends ServicioMedico {

    private List<ServicioIndividual> servicios;

}
