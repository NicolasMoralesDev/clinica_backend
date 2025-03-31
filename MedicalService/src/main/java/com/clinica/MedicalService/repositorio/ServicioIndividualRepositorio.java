package com.clinica.MedicalService.repositorio;

import com.clinica.MedicalService.modelo.Categoria;
import com.clinica.MedicalService.modelo.ServicioIndividual;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicioIndividualRepositorio extends JpaRepository<ServicioIndividual, Long> {
    List<ServicioIndividual> findByCategoria(Categoria categoria);

}
