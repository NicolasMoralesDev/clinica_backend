package com.clinica.MedicalConsultationService.repository;

import com.clinica.MedicalConsultationService.dto.MedicoDTO;
import com.clinica.MedicalConsultationService.dto.PacienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "medpatient-service")
public interface IMedPatientRepository {

    @GetMapping("/api/pacientes/obtener")
    public PacienteDTO obtenerPacientePorId(@RequestParam Long id);

    @GetMapping("/api/medicos/obtener")
    public MedicoDTO obtenerMedicoPorId(@RequestParam Long id);



}
