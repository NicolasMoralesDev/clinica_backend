package com.clinica.MedPatientService.controller;

import com.clinica.MedPatientService.dto.PacienteDTO;
import com.clinica.MedPatientService.entity.Paciente;
import com.clinica.MedPatientService.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Clase controller para pacientes
 */
@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "*")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;

    /**
     * Controlador para obtener todos los pacientes
     * @return ResponseEntity Devuelve esta entidad con el codigo de estado y un listado de pacientes
     */
    @GetMapping(value = "/obtenerTodos")
    public ResponseEntity<?> obtenerPacientes(){
        try {
            List<Paciente> medicos = pacienteService.obtenerTodos();
            return  ResponseEntity.ok().body(medicos);
        } catch (Exception e){
            return  ResponseEntity.badRequest().body("Error "+ e.getMessage());
        }
    }

    /**
     * Controlador para obtener un paciente por su id
     * @param id Recibe el id del paciente
     * @return ResponseEntity Devuelve esta entidad con el medico encontrado
     */
    @GetMapping(value = "/obtener")
    public ResponseEntity<?> obtenerPacientePorId(@RequestParam Long id){
        try {
            Paciente paciente = pacienteService.obtenerPorId(id);
            return  ResponseEntity.ok().body(paciente);
        } catch (Exception e){
            return  ResponseEntity.badRequest().body("Error "+ e.getMessage());
        }
    }

    /**
     * Controlador para registrar pacientes
     * @param pacienteDTO Recibe los datos a registrar
     * @return ResponseEntity Devuelve esta entidad con el codigo de estado y un mensaje
     */
    @PostMapping(value = "/registro")
    public ResponseEntity<?> registrarPaciente(@RequestBody PacienteDTO pacienteDTO){
        HashMap<String, String> response = new HashMap<>();

        try {
            pacienteService.crear(pacienteDTO);
            response.put("msg", "Paciente registrado correctamente!");
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            response.put("error", e.getMessage());
            return  ResponseEntity.badRequest().body("Error "+ response);
        }
    }

    /**
     * Controlador para actualizar pacientes
     * @param pacienteDTO Recibe los datos a actualizar
     * @return ResponseEntity Devuelve esta entidad con el codigo de estado y un mensaje
     */
    @PostMapping(value = "/actualizar")
    public ResponseEntity<?> actualizarPaciente(@RequestBody PacienteDTO pacienteDTO){
        HashMap<String, String> response = new HashMap<>();

        try {
            pacienteService.actualizar(pacienteDTO);
            response.put("msg", "Paciente actualizado correctamente!");
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            response.put("error", e.getMessage());
            return  ResponseEntity.badRequest().body("Error "+ response);
        }
    }

    /**
     * Controlador para suspender pacientes
     * @param id Recibe el id del paciente a suspender
     * @return ResponseEntity Devuelve esta entidad con el codigo de estado y un mensaje
     */
    @DeleteMapping(value = "/suspender")
    public ResponseEntity<?> suspenderPaciente(@RequestParam Long id){
        HashMap<String, String> response = new HashMap<>();

        try {
            pacienteService.eliminar(id);
            response.put("msg", "Paciente suspendido correctamente!");
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            response.put("error", e.getMessage());
            return  ResponseEntity.badRequest().body("Error "+ response);
        }
    }
}
