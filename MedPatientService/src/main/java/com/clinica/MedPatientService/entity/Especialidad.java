package com.clinica.MedPatientService.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase Entidad de Especialidad
 */
@Data
@Entity
@Table(name = "ESPECIALIDAD")
public class Especialidad {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "BORRADO")
    private boolean borrado;
}
