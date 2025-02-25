package com.clinica.MedicalConsultationService.service.impl;

import com.clinica.MedicalConsultationService.dto.*;
import com.clinica.MedicalConsultationService.entity.ConsultaMedica;
import com.clinica.MedicalConsultationService.mapper.IConsultaMedicaMapper;
import com.clinica.MedicalConsultationService.repository.IConsultaMedicaFiltroRepository;
import com.clinica.MedicalConsultationService.repository.IConsultaMedicaRepository;
import com.clinica.MedicalConsultationService.repository.IMedPatientRepository;
import com.clinica.MedicalConsultationService.repository.IMedicalServiceRepository;
import com.clinica.MedicalConsultationService.service.IConsultaMedicaSerice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * Clase Service para ConsultaMedica
 */
@Service
@RequiredArgsConstructor
public class ConsultaMedicaService implements IConsultaMedicaSerice {

    @Autowired
    private IConsultaMedicaRepository consultaMedicaRepository;

    @Autowired
    private IConsultaMedicaMapper consultaMedicaMapper;

    @Autowired
    private IConsultaMedicaFiltroRepository consultaMedicaFiltroRepository;

    private final IMedPatientRepository iMedPatientRepository;

    private final IMedicalServiceRepository iMedicalServiceRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ConsultaMedicaDTO> obtenerTodos(ConsultaMedicaFiltroDTO consultaMedicaFiltro) throws Exception {
        try {

//            List<ConsultaMedicaDTO> consultaMedicas =  consultaMedicaFiltroRepository.findByFilter(consultaMedicaFiltro)
//                    .stream().map(consultaMedica -> {
//                  return consultaMedicaMapper.consultaMedicaAConsultaMedicaDto(consultaMedica);
//            }).toList();

            List<ConsultaMedica> consultaMedicas = consultaMedicaRepository.findAll();

            List<ConsultaMedicaDTO> consultaMedicaDTOList = new ArrayList<>();


            consultaMedicas.forEach( item -> {
                MedicoDTO medicoDTO = iMedPatientRepository.obtenerMedicoPorId(item.getMedico());
                PacienteDTO pacienteDTO = iMedPatientRepository.obtenerPacientePorId(item.getPaciente());


                ConsultaMedicaDTO dto = new ConsultaMedicaDTO();
                dto.setId(item.getId());
                dto.setPagado(item.isPagado());
                dto.setBorrado(item.isBorrado());
                dto.setMedico(medicoDTO);
                dto.setPaciente(pacienteDTO);
                dto.setMontoTotal(iMedicalServiceRepository.obtenerMonto(item.getServicioIndividual()));
                dto.setServicioIndividual(item.getServicioIndividual());
                dto.setFechaTurno(item.getFechaTurno());
                dto.setHoraTurno(item.getHoraTurno());
                consultaMedicaDTOList.add(dto);
            });

            return consultaMedicaDTOList;
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
    public ConsultaMedica crear(ConsultaMedicaRequestDTO consultaMedicaDTO) throws Exception {
        try {
            ConsultaMedica consultaMedicaNueva = new ConsultaMedica();
            consultaMedicaNueva.setBorrado(false);
            consultaMedicaNueva.setPagado(false);
            consultaMedicaNueva.setMedico(consultaMedicaDTO.getMedico());
            consultaMedicaNueva.setPaciente(consultaMedicaDTO.getPaciente());
            consultaMedicaNueva.setHoraTurno(consultaMedicaDTO.getHoraTurno());
            consultaMedicaNueva.setFechaTurno(consultaMedicaDTO.getFechaTurno());
            consultaMedicaNueva.setMontoTotal(consultaMedicaDTO.getMontoTotal());
            consultaMedicaNueva.setServicioIndividual(consultaMedicaDTO.getServicioIndividual());
            return consultaMedicaRepository.save(consultaMedicaNueva);
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
    public void eliminar(List<Long> ids) throws Exception {
        try {
            ids.stream().forEach( id -> {
                        ConsultaMedica consultaMedica = consultaMedicaRepository.findById(id).get();
                        consultaMedica.setBorrado(true);
               }
            );
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ConsultaMedicaResponseDTO filtrarParaTurno(ConsultasMedicasParametroDTO parametro) throws Exception {
        try {
            ConsultaMedica consulta = consultaMedicaFiltroRepository.findByParameter(parametro);
            ConsultaMedicaResponseDTO response = new ConsultaMedicaResponseDTO();
            response.setHoraTurno(consulta.getHoraTurno());
            return response;
        } catch (Exception e ) {
            throw new Exception(e.getMessage());
        }
    }
}
