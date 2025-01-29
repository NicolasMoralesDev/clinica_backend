package com.clinica.MedicalService.modelo;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "idServicio")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ServicioIndividual extends ServicioMedico {


    @Column(nullable = false)
    private Double precio;
    @ManyToOne
    @JoinColumn(name = "fk_categoria", nullable = false)
    private Categoria categoria;

}
