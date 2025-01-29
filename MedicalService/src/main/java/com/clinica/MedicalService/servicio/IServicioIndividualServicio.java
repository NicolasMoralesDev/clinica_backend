package com.clinica.MedicalService.servicio;

import com.clinica.MedicalService.DTO.ServicioIndividualDTO;
import com.clinica.MedicalService.modelo.ServicioIndividual;

import java.util.List;

public interface IServicioIndividualServicio {

    List<ServicioIndividual> listarTodos();
    ServicioIndividual obtenerPorId(Long id);
    ServicioIndividual crear(ServicioIndividualDTO dto);
    ServicioIndividual actualizar(Long id, ServicioIndividualDTO dto);
    void eliminar(Long id);
    List<ServicioIndividual> obtenerPorCategoria(Long categoriaId);
    List<ServicioIndividual> obtenerTodosPorId(List<Long> listaServiciosId);


}
