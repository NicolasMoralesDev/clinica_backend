package com.clinica.finance_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TurnoDTO {

    private Long id;
    private LocalDate fechaTurno;
    private LocalTime horaTurno;
    private Long medico;
    private Long paciente;
    private double montoTotal;
    private boolean borrado;

}
