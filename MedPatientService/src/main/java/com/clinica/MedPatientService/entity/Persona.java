package com.clinica.MedPatientService.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

/**
 * Clase Abstracta base de Personas
 */
@Data
@MappedSuperclass
public abstract class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "DNI")
    private Long dni;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "FECHA_NACIMIENTO")
    private LocalDate fechaNac;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "ACTIVO")
    private boolean activo;

    private String getNombreCompleto () { return this.nombre + " " + this.apellido; }

}
