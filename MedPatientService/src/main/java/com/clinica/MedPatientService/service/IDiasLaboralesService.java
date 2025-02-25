package com.clinica.MedPatientService.service;

import com.clinica.MedPatientService.dto.BuscarTurnoDTO;
import com.clinica.MedPatientService.dto.DiaLaboralDTO;
import com.clinica.MedPatientService.entity.DiaLaboral;

import java.time.LocalTime;
import java.util.List;

public interface IDiasLaboralesService {

    List<DiaLaboral> obtenerTodos() throws Exception;
    List<LocalTime> obtenerDiasLaboralesTurno(BuscarTurnoDTO filtro) throws Exception;
    DiaLaboral obtenerPorId(Long id) throws Exception;
    DiaLaboral crear(DiaLaboralDTO diaLaboralDTO) throws Exception;
    DiaLaboral actualizar(DiaLaboralDTO diaLaboralDTO) throws Exception;
    void eliminar(Long id) throws Exception;
}
