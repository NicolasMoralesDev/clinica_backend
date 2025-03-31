package com.clinica.MedPatientService.service.impl;

import com.clinica.MedPatientService.dto.BuscarTurnoDTO;
import com.clinica.MedPatientService.dto.DiaLaboralDTO;
import com.clinica.MedPatientService.entity.DiaLaboral;
import com.clinica.MedPatientService.entity.Medico;
import com.clinica.MedPatientService.mapper.IDiaLaboralMapper;
import com.clinica.MedPatientService.repository.IDiaLaboralFiltroRepository;
import com.clinica.MedPatientService.repository.IDiaLaboralRepository;
import com.clinica.MedPatientService.service.IDiasLaboralesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase Service para DiasLaborales
 */
@Service
public class DiasLaboralesService implements IDiasLaboralesService {

    @Autowired
    private IDiaLaboralRepository diasLaboralesRepository;

    @Autowired
    private IDiaLaboralFiltroRepository diaLaboralFiltroRepository;

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

    @Override
    @Transactional(readOnly = true)
    public List<LocalTime> obtenerDiasLaboralesTurno(BuscarTurnoDTO filtro) throws Exception {
         try {
             List<DiaLaboral> turnosDisponibles = diaLaboralFiltroRepository.buscarTurnosDisponibles(filtro.getIdMedico(), LocalDate.parse(filtro.getFecha()));
             List<LocalTime> horasDisponibles = turnosDisponibles.stream().map(DiaLaboral::getHoraTurno)
                     .collect(Collectors.toList());
             return horasDisponibles;
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

            Medico medico = new Medico();
            LocalTime horaInicio = LocalTime.parse(diaLaboralDTO.getHorarioInicio());
            medico.setId(diaLaboralDTO.getMedico().getId());

            for (int i =0; i < diaLaboralDTO.getTurnosDisponibles(); i++) {

                DiaLaboral dia = new DiaLaboral();
                LocalDate fecha = LocalDate.parse(diaLaboralDTO.getFecha());
                LocalTime hora = horaInicio.plusHours(i);
                dia.setHoraTurno(hora);
                dia.setDisponible(true);
                dia.setFechaTurno(fecha);
                dia.setMedico(medico);
                diasLaboralesRepository.save(dia);
            }
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
