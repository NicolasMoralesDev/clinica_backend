package com.clinica.MedPatientService.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

/**
 * Clase Entidad de Paciente
 */
@Data
@Entity
@Table(name = "PACIENTE")
public class Paciente extends Persona {

    @Column(name = "ENFERMEDAD")
    @ManyToMany
    private Set<Enfermedad> enfermedad;
    @Column(name = "OBRA_SOCIAL")
    private boolean obraSocial;
}
