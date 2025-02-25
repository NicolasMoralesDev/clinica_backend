package com.clinica.MedPatientService.repository;

import com.clinica.MedPatientService.entity.DiaLaboral;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface IDiaLaboralFiltroRepository {

    List<DiaLaboral> buscarTurnosDisponibles(Long idMedico, LocalDate fecha);

}
