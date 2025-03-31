package com.clinica.MedicalService.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value =  ServicioIndividual.class, name = "ServicioIndividual"),
        @JsonSubTypes.Type(value = Paquete.class, name = "Paquete")
}
)
public abstract class ServicioMedico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServicio;
    @Column(nullable = false, unique = true)
    private String nombre;
    @Column(nullable = false, unique = true)
    private String codigo;
    @Column(nullable = false)
    private String descripcion;
    private Boolean borrado;
    private Double precio;

}
