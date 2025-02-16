package com.clinica.MedicalConsultationService.service.impl;

import com.clinica.MedicalConsultationService.dto.ConsultaMedicaDTO;
import com.clinica.MedicalConsultationService.dto.ConsultaMedicaFiltroDTO;
import com.clinica.MedicalConsultationService.dto.MedicoDTO;
import com.clinica.MedicalConsultationService.dto.PacienteDTO;
import com.clinica.MedicalConsultationService.entity.ConsultaMedica;
import com.clinica.MedicalConsultationService.mapper.IConsultaMedicaMapper;
import com.clinica.MedicalConsultationService.repository.IConsultaMedicaFiltroRepository;
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

    @Autowired
    private IConsultaMedicaFiltroRepository consultaMedicaFiltroRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ConsultaMedicaDTO> obtenerTodos(ConsultaMedicaFiltroDTO consultaMedicaFiltro) throws Exception {
        try {
            List<ConsultaMedicaDTO> consultaMedicas =  consultaMedicaFiltroRepository.findByFilter(consultaMedicaFiltro)
                    .stream().map(consultaMedica -> {
                  return consultaMedicaMapper.consultaMedicaAConsultaMedicaDto(consultaMedica);
            }).toList();

            MedicoDTO medicoDTO = new MedicoDTO();
            medicoDTO.setNombre("Nicolas Morales");
            medicoDTO.setId(1L);

            PacienteDTO pacienteDTO = new PacienteDTO();
            pacienteDTO.setId(1L);
            pacienteDTO.setNombre("Mauricio primatesta");
            pacienteDTO.setEmail("nico@gmail.com");
            pacienteDTO.setDireccion("siempre viva 1234");
            pacienteDTO.setDni("44679734");
            pacienteDTO.setObraSocial(true);

            consultaMedicas.stream().forEach(consulta -> {
                consulta.setId(1L);
                consulta.setPaciente(pacienteDTO);
                consulta.setMedico(medicoDTO);
            });
            return consultaMedicas;
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
}
