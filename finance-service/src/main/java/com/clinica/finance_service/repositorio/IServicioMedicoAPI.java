package com.clinica.finance_service.repositorio;

import com.clinica.finance_service.DTO.ServicioMedico;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "medical-service")
public interface IServicioMedicoAPI {

    @GetMapping("/servicio-medico/{id}")
    public ServicioMedico getById(@PathVariable Long id);


}
