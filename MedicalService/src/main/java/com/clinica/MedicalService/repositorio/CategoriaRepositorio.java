package com.clinica.MedicalService.repositorio;

import com.clinica.MedicalService.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
}
