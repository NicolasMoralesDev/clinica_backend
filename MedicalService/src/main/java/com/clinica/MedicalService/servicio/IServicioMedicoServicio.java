package com.clinica.MedicalService.servicio;

import com.clinica.MedicalService.modelo.ServicioMedico;

import java.util.List;

public interface IServicioMedicoServicio {

    List<ServicioMedico> listarTodos();
    ServicioMedico obtenerPorId(Long id);


}
