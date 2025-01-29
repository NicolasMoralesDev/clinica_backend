package com.clinica.MedicalService.servicio;

import com.clinica.MedicalService.DTO.ServicioIndividualDTO;
import com.clinica.MedicalService.modelo.ServicioMedico;

import java.util.List;

public interface IServicioMedicoServicio {

    List<ServicioMedico> listarTodos();
    ServicioMedico obtenerPorId(Long id);
    ServicioMedico crear(ServicioIndividualDTO dto);
    ServicioMedico actualizar(ServicioIndividualDTO dto);
    String eliminar(Long id);


}
