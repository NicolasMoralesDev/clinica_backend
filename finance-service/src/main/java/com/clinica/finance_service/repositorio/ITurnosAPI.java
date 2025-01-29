package com.clinica.finance_service.repositorio;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "MedicalConsultationService")
public interface ITurnosAPI {
}
