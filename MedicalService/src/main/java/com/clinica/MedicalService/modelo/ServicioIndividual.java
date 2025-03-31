package com.clinica.MedicalService.modelo;

import com.fasterxml.jackson.annotation.JsonTypeName;
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


    @ManyToOne
    @JoinColumn(name = "fk_categoria", nullable = false)
    private Categoria categoria;

}
