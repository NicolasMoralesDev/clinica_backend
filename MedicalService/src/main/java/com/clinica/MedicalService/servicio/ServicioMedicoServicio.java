package com.clinica.MedicalService.servicio;

import com.clinica.MedicalService.modelo.Paquete;
import com.clinica.MedicalService.modelo.ServicioIndividual;
import com.clinica.MedicalService.modelo.ServicioMedico;
import com.clinica.MedicalService.repositorio.ServicioMedicoRepositorio;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioMedicoServicio implements IServicioMedicoServicio {

    private final ServicioMedicoRepositorio servicioMedicoRepositorio;

    @Override
    public List<ServicioMedico> listarTodos() {
        return servicioMedicoRepositorio.findAll();
    }

    @Override
    public ServicioMedico obtenerPorId(Long id) {
        ServicioMedico servicioMedico = servicioMedicoRepositorio.findById(id).orElse(null);
        return servicioMedico;
    }

}
