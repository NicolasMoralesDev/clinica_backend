package com.clinica.MedPatientService.service;

import com.clinica.MedPatientService.dto.PacienteDTO;
import com.clinica.MedPatientService.entity.Paciente;

import java.util.List;

public interface IPacienteService {

    List<Paciente> obtenerTodos() throws Exception;
    Paciente obtenerPorId(Long id) throws Exception;
    Paciente crear(PacienteDTO paciente) throws Exception;
    Paciente actualizar(PacienteDTO paciente) throws Exception;
    void eliminar(Long id) throws Exception;
}
