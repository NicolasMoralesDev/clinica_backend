package com.clinica.MedPatientService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Clase main del servidor
 */
@SpringBootApplication
public class MedPatientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedPatientServiceApplication.class, args);
	}

}
