package com.clinica.MedPatientService.controller;

import com.clinica.MedPatientService.dto.EspecialidadDTO;
import com.clinica.MedPatientService.entity.Especialidad;
import com.clinica.MedPatientService.service.IEspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Clase controller para Especialidades
 */
@RestController
@RequestMapping("/api/especialidad")
@CrossOrigin(origins = "*")
public class EspecialidadController {

    @Autowired
    private IEspecialidadService especialidadService;

    /**
     * Controlador para obtener todas las especialidades
     * @return ResponseEntity Devuelve esta entidad con el codigo de estado y un listado de especialidades
     */
    @GetMapping(value = "/obtenerTodas")
    public ResponseEntity<?> obtenerEspecialidades(){
        try {
            List<Especialidad> especialidad = especialidadService.obtenerTodos();
            return  ResponseEntity.ok().body(especialidad);
        } catch (Exception e){
            return  ResponseEntity.badRequest().body("Error "+ e.getMessage());
        }
    }

    /**
     * Controlador para obtener una especialidad por su id
     * @param id Recibe el id de la especialidad
     * @return ResponseEntity Devuelve esta entidad con la especialidad encontrada
     */
    @GetMapping(value = "/obtener")
    public ResponseEntity<?> obtenerEspecialidadPorId(@RequestParam Long id){
        try {
            Especialidad especialidad = especialidadService.obtenerPorId(id);
            return  ResponseEntity.ok().body(especialidad);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Controlador para registrar especialidades
     * @param especialidadDTO Recibe los datos a registrar
     * @return ResponseEntity Devuelve esta entidad con el codigo de estado y un mensaje
     */
    @PostMapping(value = "/registro")
    public ResponseEntity<?> registrarPaciente(@RequestBody EspecialidadDTO especialidadDTO){
        HashMap<String, String> response = new HashMap<>();

        try {
            especialidadService.crear(especialidadDTO);
            response.put("msg", "Especialidad registrada correctamente!");
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            response.put("error", e.getMessage());
            return  ResponseEntity.badRequest().body("Error "+ response);
        }
    }

    /**
     * Controlador para actualizar especialidades
     * @param especialidadDTO Recibe los datos a actualizar
     * @return ResponseEntity Devuelve esta entidad con el codigo de estado y un mensaje
     */
    @PostMapping(value = "/actualizar")
    public ResponseEntity<?> actualizarEspecialidad(@RequestBody EspecialidadDTO especialidadDTO){
        HashMap<String, String> response = new HashMap<>();

        try {
            especialidadService.actualizar(especialidadDTO);
            response.put("msg", "Especialidad actualizada correctamente!");
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            response.put("error", e.getMessage());
            return  ResponseEntity.badRequest().body("Error "+ response);
        }
    }

    /**
     * Controlador para borrar especialidades
     * @param id Recibe el id de la especialidad a borrar
     * @return ResponseEntity Devuelve esta entidad con el codigo de estado y un mensaje
     */
    @DeleteMapping(value = "/suspender")
    public ResponseEntity<?> borrarEspecialidad(@RequestParam Long id){
        HashMap<String, String> response = new HashMap<>();

        try {
            especialidadService.eliminar(id);
            response.put("msg", "Especialidad borrada correctamente!");
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            response.put("error", e.getMessage());
            return  ResponseEntity.badRequest().body("Error "+ response);
        }
    }
}
