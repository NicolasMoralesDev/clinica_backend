package com.clinica.finance_service.repositorio;

import com.clinica.finance_service.DTO.PacienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "MedPatientService")
public interface IPacientesAPI {

    @GetMapping("/api/pacientes/obtener")
    public PacienteDTO getPacienteById(@RequestParam Long id);

}
