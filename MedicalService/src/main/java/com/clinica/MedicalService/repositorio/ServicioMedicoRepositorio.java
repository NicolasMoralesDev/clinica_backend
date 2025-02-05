package com.clinica.MedicalService.repositorio;

import com.clinica.MedicalService.modelo.ServicioMedico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicioMedicoRepositorio extends JpaRepository<ServicioMedico, Long> {
}
