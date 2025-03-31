package com.clinica.MedPatientService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Clase Main del Servidor
 */
@EnableFeignClients
@SpringBootApplication
public class MedPatientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedPatientServiceApplication.class, args);
	}

}
