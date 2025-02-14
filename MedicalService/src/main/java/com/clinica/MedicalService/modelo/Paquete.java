package com.clinica.MedicalService.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "idServicio")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Paquete extends ServicioMedico{

    @ManyToMany
    @JoinTable(
            name = "paquete_servicio",
            joinColumns = @JoinColumn(name = "paquete_id"),
            inverseJoinColumns = @JoinColumn(name = "servicio_id")
    )
    private List<ServicioIndividual> servicios;

    @Transient
    private Double precio;

    @JsonProperty("precio")
    public Double getPrecio(){
        if(servicios == null || servicios.isEmpty()){
            return 0.00;
        }

        double precioTotal = servicios.stream()
                .mapToDouble(ServicioIndividual::getPrecio).sum();

        return precioTotal * 0.85; // RETORNO EL PRECIO CON EL 15% DE DESCUENTO
    }

}
