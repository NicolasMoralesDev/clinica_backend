package com.clinica.MedicalConsultationService.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;


/**
 * Clase Entidad de ConsultaMedica
 */
@Entity
@Data
@Table(name = "CONSULTA_MNEDICA")
public class ConsultaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "FECHA_TURNO")
    private LocalDate fechaTurno;
    @Column(name = "HORA_TURNO")
    private LocalTime horaTurno;
    @Column(name = "MEDICO_ID")
    private Long medico;
    @Column(name = "PACIENTE_ID")
    private Long paciente;
    @Column(name = "MONTO_TOTAL")
    private double montoTotal;
    @Column(name = "BORRADO")
    private boolean borrado;

}
