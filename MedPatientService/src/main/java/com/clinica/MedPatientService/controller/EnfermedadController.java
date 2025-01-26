package com.clinica.MedPatientService.controller;

import com.clinica.MedPatientService.dto.EnfermedadDTO;
import com.clinica.MedPatientService.entity.Enfermedad;
import com.clinica.MedPatientService.service.IEnfermedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Clase controller para Enfermedades
 */
@RestController
@RequestMapping("/api/enfermedades")
@CrossOrigin(origins = "*")
public class EnfermedadController {

    @Autowired
    private IEnfermedadService enfermedadService;

    /**
     * Controlador para obtener todas las enfermedades
     * @return ResponseEntity Devuelve esta entidad con el codigo de estado y un listado de pacientes
     */
    @GetMapping(value = "/obtenerTodas")
    public ResponseEntity<?> obtenerEnfermedades(){
        try {
            List<Enfermedad> medicos = enfermedadService.obtenerTodos();
            return  ResponseEntity.ok().body(medicos);
        } catch (BussinesException e){
            return  ResponseEntity.badRequest().body("Error "+ e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Controlador para obtener una enfermedad por su id
     * @param id Recibe el id de la enfermedad
     * @return ResponseEntity Devuelve esta entidad con la enfermedad encontrado
     */
    @GetMapping(value = "/obtener")
    public ResponseEntity<?> obtenerEnfermedadPorId(@RequestParam Long id){
        try {
            Enfermedad enfermedad = enfermedadService.obtenerPorId(id);
            return  ResponseEntity.ok().body(enfermedad);
        } catch (BussinesException e){
            return  ResponseEntity.badRequest().body("Error "+ e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Controlador para registrar enfermedades
     * @param enfermedadDTO Recibe los datos a registrar
     * @return ResponseEntity Devuelve esta entidad con el codigo de estado y un mensaje
     */
    @PostMapping(value = "/registro")
    public ResponseEntity<?> registrarEnfermedades(@RequestBody EnfermedadDTO enfermedadDTO){
        HashMap<String, String> response = new HashMap<>();

        try {
            enfermedadService.crear(enfermedadDTO);
            response.put("msg", "Enfermedad registrada correctamente!");
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            response.put("error", e.getMessage());
            return  ResponseEntity.badRequest().body("Error "+ response);
        }
    }

    /**
     * Controlador para actualizar enfermedades
     * @param enfermedadDTO Recibe los datos a actualizar
     * @return ResponseEntity Devuelve esta entidad con el codigo de estado y un mensaje
     */
    @PostMapping(value = "/actualizar")
    public ResponseEntity<?> actualizarEnfermedad(@RequestBody EnfermedadDTO enfermedadDTO){
        HashMap<String, String> response = new HashMap<>();

        try {
            enfermedadService.actualizar(enfermedadDTO);
            response.put("msg", "Enfermedad actualizada correctamente!");
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            response.put("error", e.getMessage());
            return  ResponseEntity.badRequest().body("Error "+ response);
        }
    }

    /**
     * Controlador para borrar enfermedades
     * @param id Recibe el id de la enfermedad a borrar
     * @return ResponseEntity Devuelve esta entidad con el codigo de estado y un mensaje
     */
    @PostMapping(value = "/borrar")
    public ResponseEntity<?> borrarEnfermedad(@RequestParam Long id){
        HashMap<String, String> response = new HashMap<>();

        try {
            enfermedadService.eliminar(id);
            response.put("msg", "Enfermedad borrada correctamente!");
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            response.put("error", e.getMessage());
            return  ResponseEntity.badRequest().body("Error "+ response);
        }
    }
}
