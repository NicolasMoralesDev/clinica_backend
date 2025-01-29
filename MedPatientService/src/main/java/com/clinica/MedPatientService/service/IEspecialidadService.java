package com.clinica.MedPatientService.service;

import com.clinica.MedPatientService.dto.EspecialidadDTO;
import com.clinica.MedPatientService.entity.Especialidad;

import java.util.List;

public interface IEspecialidadService {

    List<Especialidad> obtenerTodos() throws Exception;
    Especialidad obtenerPorId(Long id) throws Exception;
    Especialidad crear(EspecialidadDTO especialidad) throws Exception;
    Especialidad actualizar(EspecialidadDTO especialidad) throws Exception;
    void eliminar(Long id) throws Exception;
}
