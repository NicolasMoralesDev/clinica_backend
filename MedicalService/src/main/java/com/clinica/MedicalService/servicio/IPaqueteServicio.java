package com.clinica.MedicalService.servicio;

import com.clinica.MedicalService.DTO.PaqueteConPrecioDTOResponse;
import com.clinica.MedicalService.DTO.PaqueteDTO;
import com.clinica.MedicalService.modelo.Paquete;

import java.util.List;

public interface IPaqueteServicio {

    List<Paquete> listarTodos();
    Paquete obtenerPorId(Long id);
    Paquete crear(PaqueteDTO dto);
    Paquete actualizar(Long id, PaqueteDTO dto);
    void eliminar(Long id);
    PaqueteConPrecioDTOResponse obtenerPaqueteConPrecio(Long id);



}
