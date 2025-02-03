package com.clinica.finance_service.repositorio;


import com.clinica.finance_service.DTO.ConsultaMedicaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "MedicalConsultationService")
public interface ITurnosAPI {

    @GetMapping("/api/consultasMedicas/obtenerTodas")
    public List<ConsultaMedicaDTO> getConsultasMedicas();

    @GetMapping("/api/consultasMedicas/obtener")
    public ConsultaMedicaDTO getConsultasMedicasPorId(@RequestParam Long id);


}
