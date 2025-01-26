package com.clinica.MedPatientService.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase Entidad de Enfermedad
 */
@Data
@Entity
@Table(name = "ENFERMEDAD")
public class Enfermedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "BORRADO")
    private boolean borrado;
}
