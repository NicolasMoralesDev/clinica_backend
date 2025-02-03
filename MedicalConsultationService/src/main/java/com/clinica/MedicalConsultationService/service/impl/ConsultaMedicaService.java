package com.clinica.MedicalConsultationService.service.impl;

import com.clinica.MedicalConsultationService.dto.ConsultaMedicaDTO;
import com.clinica.MedicalConsultationService.entity.ConsultaMedica;
import com.clinica.MedicalConsultationService.mapper.IConsultaMedicaMapper;
import com.clinica.MedicalConsultationService.repository.IConsultaMedicaRepository;
import com.clinica.MedicalConsultationService.service.IConsultaMedicaSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Clase Service para ConsultaMedica
 */
@Service
public class ConsultaMedicaService implements IConsultaMedicaSerice {

    @Autowired
    private IConsultaMedicaRepository consultaMedicaRepository;

    @Autowired
    private IConsultaMedicaMapper consultaMedicaMapper;

    @Transactional(readOnly = true)
    @Override
    public List<ConsultaMedica> obtenerTodos() throws Exception {
        try {
            return consultaMedicaRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public ConsultaMedica obtenerPorId(Long id) throws Exception {
        try {
            return consultaMedicaRepository.findById(id).get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ConsultaMedica crear(ConsultaMedicaDTO consultaMedicaDTO) throws Exception {
        try {
            return consultaMedicaRepository.save(consultaMedicaMapper.consultaMedicaDtoAConsultaMedica(consultaMedicaDTO));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ConsultaMedica actualizar(ConsultaMedicaDTO consultaMedicaDTO) throws Exception {
        try {
            return consultaMedicaRepository.save(consultaMedicaMapper.consultaMedicaDtoAConsultaMedica(consultaMedicaDTO));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void eliminar(Long id) throws Exception {
        try {
            ConsultaMedica consultaMedica = consultaMedicaRepository.findById(id).get();
            consultaMedica.setBorrado(true);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
