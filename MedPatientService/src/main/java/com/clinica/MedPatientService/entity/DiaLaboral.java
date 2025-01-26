package com.clinica.MedPatientService.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase Entidad de DiasLaborales
 */
@Entity
@Data
@Table(name = "DIA_LABORAL")
public class DiaLaboral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Medico medico;
    @Column(name = "TURNOS_DISPONIBLES")
    private int turnosDisponibles;
    @Column(name = "HORARIO_INICIO")
    private int horarioInicio;
    @Column(name = "BORRADO")
    private boolean borrado;
}
