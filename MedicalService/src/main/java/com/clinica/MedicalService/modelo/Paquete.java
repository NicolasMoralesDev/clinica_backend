package com.clinica.MedicalService.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

}
