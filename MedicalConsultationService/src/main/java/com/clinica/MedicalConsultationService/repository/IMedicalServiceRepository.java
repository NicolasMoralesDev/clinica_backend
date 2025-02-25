package com.clinica.MedicalConsultationService.repository;

import com.clinica.MedicalConsultationService.dto.MedicoDTO;
import com.clinica.MedicalConsultationService.dto.PacienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "medical-service")
public interface IMedicalServiceRepository {

    @GetMapping("/servicio-medico/{id}/monto")
    public Double obtenerMonto(@RequestParam Long id);

}
