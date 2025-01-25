package com.clinica.MedicalService.modelo;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ServicioMedico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServicio;
    @Column(nullable = false, unique = true)
    private String nombre;
    @Column(nullable = false, unique = true)
    private String codigo;
    @Column(nullable = false)
    private String descripcion;
    private Boolean borrado;

}
