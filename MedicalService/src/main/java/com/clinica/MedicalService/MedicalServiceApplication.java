package com.clinica.MedicalService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MedicalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalServiceApplication.class, args);
	}

}
