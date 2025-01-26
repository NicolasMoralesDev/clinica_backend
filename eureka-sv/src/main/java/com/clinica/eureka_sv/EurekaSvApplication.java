package com.clinica.eureka_sv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Clase Main del Servidor
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaSvApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaSvApplication.class, args);
	}

}
