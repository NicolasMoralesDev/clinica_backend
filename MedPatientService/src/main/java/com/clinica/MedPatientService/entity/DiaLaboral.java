package com.clinica.MedPatientService.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id", referencedColumnName = "id")
    private Medico medico;
    @Column(name = "FECHA_TURNO")
    private LocalDate fechaTurno;
    @Column(name = "HORA_TURNO")
    private LocalTime horaTurno;
    @Column(name = "DISPONIBLE")
    private boolean disponible;
    @Column(name = "BORRADO")
    private boolean borrado;
}
