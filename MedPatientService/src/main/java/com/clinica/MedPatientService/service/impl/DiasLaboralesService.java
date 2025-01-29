package com.clinica.MedPatientService.service.impl;

import com.clinica.MedPatientService.dto.DiaLaboralDTO;
import com.clinica.MedPatientService.entity.DiaLaboral;
import com.clinica.MedPatientService.mapper.IDiaLaboralMapper;
import com.clinica.MedPatientService.repository.IDiaLaboralRepository;
import com.clinica.MedPatientService.service.IDiasLaboralesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Clase Service para DiasLaborales
 */
@Service
public class DiasLaboralesService implements IDiasLaboralesService {

    @Autowired
    private IDiaLaboralRepository diasLaboralesRepository;

    @Autowired
    private IDiaLaboralMapper diaLaboralMapper;

    @Transactional(readOnly = true)
    @Override
    public List<DiaLaboral> obtenerTodos() throws Exception {
        try {
            return diasLaboralesRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public DiaLaboral obtenerPorId(Long id) throws Exception {
        try {
            return diasLaboralesRepository.findById(id).get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public DiaLaboral crear(DiaLaboralDTO diaLaboralDTO) throws Exception {
        try {
            return diasLaboralesRepository.save(diaLaboralMapper.diaLaboralDtoADiasLaboral(diaLaboralDTO));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public DiaLaboral actualizar(DiaLaboralDTO diaLaboralDTO) throws Exception {
        try {
            return diasLaboralesRepository.save(diaLaboralMapper.diaLaboralDtoADiasLaboral(diaLaboralDTO));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void eliminar(Long id) throws Exception {
        try {
            DiaLaboral diaLaboral = diasLaboralesRepository.findById(id).get();
            diaLaboral.setBorrado(true);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
