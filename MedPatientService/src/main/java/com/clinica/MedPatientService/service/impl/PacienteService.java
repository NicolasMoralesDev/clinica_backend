package com.clinica.MedPatientService.service.impl;

import com.clinica.MedPatientService.dto.PacienteDTO;
import com.clinica.MedPatientService.entity.Paciente;
import com.clinica.MedPatientService.mapper.IPacienteMapper;
import com.clinica.MedPatientService.repository.IPacienteRepository;
import com.clinica.MedPatientService.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Clase Service para Pacientes
 */
@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private IPacienteMapper pacienteMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Paciente> obtenerTodos() throws Exception {
        try {
            return pacienteRepository.findAll();
        } catch (Exception e) {
          throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Paciente obtenerPorId(Long id) throws Exception {
        try {
            return pacienteRepository.findById(id).get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Paciente crear(PacienteDTO paciente) throws Exception {
        try {
            return pacienteRepository.save(pacienteMapper.pacienteDtoAPaciente(paciente));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Paciente actualizar(PacienteDTO paciente) throws Exception {
        try {
            return pacienteRepository.save(pacienteMapper.pacienteDtoAPaciente(paciente));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void eliminar(Long id) throws Exception {
        try {
            Paciente paciente = pacienteRepository.findById(id).get();
            paciente.setActivo(true);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
