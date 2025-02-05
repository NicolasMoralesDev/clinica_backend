package com.clinica.finance_service.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ConsultaMedicaDTO {

    private Long id;
    private LocalDate fechaTurno;
    private LocalTime horaTurno;
    private Long medico;
    private Long paciente;
    private Long servicioIndividual;
    private double montoTotal;
    private boolean borrado;

}
