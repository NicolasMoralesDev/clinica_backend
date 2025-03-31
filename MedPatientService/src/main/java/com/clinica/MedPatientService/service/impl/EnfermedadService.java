package com.clinica.MedPatientService.service.impl;

import com.clinica.MedPatientService.dto.EnfermedadDTO;
import com.clinica.MedPatientService.entity.Enfermedad;
import com.clinica.MedPatientService.mapper.IEnfermedadMapper;
import com.clinica.MedPatientService.repository.IEnfermedadRepository;
import com.clinica.MedPatientService.service.IEnfermedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Clase Service para Enfermedad
 */
@Service
public class EnfermedadService implements IEnfermedadService {

    @Autowired
    private IEnfermedadRepository enfermedadRepository;

    @Autowired
    private IEnfermedadMapper enfermedadMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Enfermedad> obtenerTodos() throws Exception {
        try {
            return enfermedadRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Enfermedad obtenerPorId(Long id) throws Exception {
        try {
            return enfermedadRepository.findById(id).get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Enfermedad crear(EnfermedadDTO enfermedadDTO) throws Exception {
        try {
            return enfermedadRepository.save(enfermedadMapper.enfermedadDtoAEnfermedad(enfermedadDTO));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Enfermedad actualizar(EnfermedadDTO enfermedadDTO) throws Exception {
        try {
            return enfermedadRepository.save(enfermedadMapper.enfermedadDtoAEnfermedad(enfermedadDTO));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void eliminar(Long id) throws Exception {
        try {
            Enfermedad enfermedad = enfermedadRepository.findById(id).get();
            enfermedad.setBorrado(true);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
