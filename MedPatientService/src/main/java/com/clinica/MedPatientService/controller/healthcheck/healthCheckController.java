package com.clinica.MedPatientService.controller.healthcheck;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase controller health-check
 */
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class healthCheckController {

    @Value("${version}")
    private String version;

    @GetMapping("/health-check")
    public ResponseEntity<?> getHealthCheck() {
        return ResponseEntity.ok().body("OK");
    }

    @GetMapping("/version")
    public ResponseEntity<?> getVersion() {
        return ResponseEntity.ok().body(version);
    }
}
