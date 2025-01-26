package com.clinica.MedPatientService.service;

import com.clinica.MedPatientService.dto.EnfermedadDTO;
import com.clinica.MedPatientService.entity.Enfermedad;

import java.util.List;

public interface IEnfermedadService {

    List<Enfermedad> obtenerTodos() throws Exception;
    Enfermedad obtenerPorId(Long id) throws Exception;
    Enfermedad crear(EnfermedadDTO enfermedadDTO) throws Exception;
    Enfermedad actualizar(EnfermedadDTO enfermedadDTO) throws Exception;
    void eliminar(Long id) throws Exception;
}
