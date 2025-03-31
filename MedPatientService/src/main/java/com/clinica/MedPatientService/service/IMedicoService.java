package com.clinica.MedPatientService.service;

import com.clinica.MedPatientService.dto.MedicoDTO;
import com.clinica.MedPatientService.entity.Medico;

import java.util.List;

public interface IMedicoService {

    List<Medico> obtenerTodos() throws Exception;
    Medico obtenerPorId(Long id) throws Exception;
    Medico crear(MedicoDTO medico) throws Exception;
    Medico actualizar(MedicoDTO medico) throws Exception;
    void eliminar(Long id) throws Exception;
}
