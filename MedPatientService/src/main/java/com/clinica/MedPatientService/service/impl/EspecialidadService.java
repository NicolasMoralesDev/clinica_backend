package com.clinica.MedPatientService.service.impl;

import com.clinica.MedPatientService.dto.EspecialidadDTO;
import com.clinica.MedPatientService.entity.Especialidad;
import com.clinica.MedPatientService.mapper.IEspecialidadMapper;
import com.clinica.MedPatientService.repository.IEspecialidadRepository;
import com.clinica.MedPatientService.service.IEspecialidadService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase Service para Especialidad
 */
@Service
public class EspecialidadService implements IEspecialidadService {

    @Autowired
    private IEspecialidadRepository especialidadRepository;

    @Autowired
    private IEspecialidadMapper especialidadMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Especialidad> obtenerTodos() throws Exception {
        try {
            return especialidadRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Especialidad obtenerPorId(Long id) throws Exception {
        try {
            return especialidadRepository.findById(id).get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Especialidad crear(EspecialidadDTO especialidad) throws Exception {
        try {
            return especialidadRepository.save(especialidadMapper.especialidadDtoAEspecialidad(especialidad));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Especialidad actualizar(EspecialidadDTO especialidad) throws Exception {
        try {
            return especialidadRepository.save(especialidadMapper.especialidadDtoAEspecialidad(especialidad));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void eliminar(Long id) throws Exception {
        try {
            Especialidad especialidad = especialidadRepository.findById(id).get();
            especialidad.setBorrado(true);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
