package com.clinica.MedPatientService.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

/**
 * Clase Entidad de Medico
 */
@Data
@Entity
@Table(name = "MEDICO")
public class Medico extends Persona {

    @Column(name = "SUELDO")
    private double sueldo;
    @ManyToOne
    private Especialidad especialidad;
    @OneToMany
    private Set<DiaLaboral> diaLaborales;

}
