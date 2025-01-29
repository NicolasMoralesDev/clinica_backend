package com.clinica.MedicalService.servicio;

import com.clinica.MedicalService.DTO.CategoriaDTO;
import com.clinica.MedicalService.modelo.Categoria;

import java.util.List;

public interface ICategoriaServicio {

    List<Categoria> listarTodos();
    Categoria obtenerPorId(Long id);
    Categoria crear(CategoriaDTO dto);
    Categoria actualizar(Long id, CategoriaDTO dto);
    void eliminar(Long id);

}
