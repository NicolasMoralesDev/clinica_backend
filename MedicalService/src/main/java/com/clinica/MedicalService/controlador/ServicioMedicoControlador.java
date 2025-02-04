package com.clinica.MedicalService.controlador;

import com.clinica.MedicalService.modelo.ServicioMedico;
import com.clinica.MedicalService.servicio.ServicioMedicoServicio;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/servicio-medico")
public class ServicioMedicoControlador {

    private final ServicioMedicoServicio servicioMedicoServicio;


    @GetMapping
    public ResponseEntity<List<ServicioMedico>> getAll(){
        List<ServicioMedico> servicioMedicoList = servicioMedicoServicio.listarTodos();
        return ResponseEntity.ok(servicioMedicoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicioMedico> getById(@PathVariable Long id){
        ServicioMedico servicioMedico = servicioMedicoServicio.obtenerPorId(id);
        return ResponseEntity.ok(servicioMedico);
    }




}
