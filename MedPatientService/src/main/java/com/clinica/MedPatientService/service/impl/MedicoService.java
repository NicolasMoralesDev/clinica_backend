package com.clinica.MedPatientService.service.impl;

import com.clinica.MedPatientService.dto.MedicoDTO;
import com.clinica.MedPatientService.entity.Medico;
import com.clinica.MedPatientService.mapper.IMedicoMapper;
import com.clinica.MedPatientService.repository.IMedicoRepository;
import com.clinica.MedPatientService.service.IMedicoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase Service para Medicos
 */
@Service
public class MedicoService implements IMedicoService {

    @Autowired
    private IMedicoRepository medicoRepository;

    @Autowired
    private IMedicoMapper medicoMapper;

    @Override
    public List<Medico> obtenerTodos() throws Exception {
        try {
            return medicoRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Medico obtenerPorId(Long id) throws Exception {
        try {
            return medicoRepository.findById(id).get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Medico crear(MedicoDTO medico) throws Exception {
        try {
            return medicoRepository.save(medicoMapper.medicoDtoAMedico(medico));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Medico actualizar(MedicoDTO medico) throws Exception {
        try {
            return medicoRepository.save(medicoMapper.medicoDtoAMedico(medico));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void eliminar(Long id) throws Exception {
        try {
            Medico medico = medicoRepository.findById(id).get();
            medico.setActivo(true);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
