package com.clinica.finance_service.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@Getter
@Setter
@ToString
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value =  ServicioIndividual.class, name = "ServicioIndividual"),
        @JsonSubTypes.Type(value = Paquete.class, name = "Paquete")
}
)
public abstract class ServicioMedico {

    private String tipo;
    private Long idServicio;
    private String nombre;
    private String codigo;
    private String descripcion;
    private Boolean borrado;
    private Double precio;

}
