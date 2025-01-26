package com.clinica.MedPatientService.controller;

import com.clinica.MedPatientService.dto.MedicoDTO;
import com.clinica.MedPatientService.entity.Medico;
import com.clinica.MedPatientService.service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


/**
 * Clase controller para medicos
 */
@RestController
@RequestMapping("/api/medicos")
@CrossOrigin(origins = "*")
public class MedicoController {

    @Autowired
    private IMedicoService medicoService;

    /**
     * Controlador para obtener todos los medicos
     * @return ResponseEntity Devuelve esta entidad con el codigo de estado y un listado de medicos
     */
    @GetMapping(value = "/obtenerTodos")
    public ResponseEntity<?> obtenerMedicos(){
        try {
            List<Medico> medicos = medicoService.obtenerTodos();
            return  ResponseEntity.ok().body(medicos);
        } catch (Exception e){
            return  ResponseEntity.badRequest().body("Error "+ e.getMessage());
        }
    }

    /**
     * Controlador para obtener un medico por su id
     * @param id Recibe el id del Medico
     * @return ResponseEntity Devuelve esta entidad con el medico encontrado
     */
    @GetMapping(value = "/obtener")
    public ResponseEntity<?> obtenerMedicoPorId(@RequestParam Long id){
        try {
            Medico medico = medicoService.obtenerPorId(id);
            return  ResponseEntity.ok().body(medico);
        } catch (Exception e){
            return  ResponseEntity.badRequest().body("Error "+ e.getMessage());
        }
    }

    /**
     * Controlador para registrar medicos
     * @param medicoDTO Recibe los datos a registrar
     * @return ResponseEntity Devuelve esta entidad con el codigo de estado y un mensaje
     */
    @PostMapping(value = "/registro")
    public ResponseEntity<?> registrarMedico(@RequestBody MedicoDTO medicoDTO){
        HashMap<String, String> response = new HashMap<>();

        try {
            medicoService.crear(medicoDTO);
            response.put("msg", "Medico registrado correctamente!");
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            response.put("error", e.getMessage());
            return  ResponseEntity.badRequest().body("Error "+ response);
        }
    }

    /**
     * Controlador para actualizar medicos
     * @param medicoDTO Recibe los datos a actualizar
     * @return ResponseEntity Devuelve esta entidad con el codigo de estado y un mensaje
     */
    @PostMapping(value = "/actualizar")
    public ResponseEntity<?> actualizarMedico(@RequestBody MedicoDTO medicoDTO){
        HashMap<String, String> response = new HashMap<>();

        try {
            medicoService.actualizar(medicoDTO);
            response.put("msg", "Medico actualizado correctamente!");
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            response.put("error", e.getMessage());
            return  ResponseEntity.badRequest().body("Error "+ response);
        }
    }

    /**
     * Controlador para suspender medicos
     * @param id Recibe el id del medico a suspender
     * @return ResponseEntity Devuelve esta entidad con el codigo de estado y un mensaje
     */
    @DeleteMapping(value = "/suspender")
    public ResponseEntity<?> suspenderMedico(@RequestParam Long id){
        HashMap<String, String> response = new HashMap<>();

        try {
            medicoService.eliminar(id);
            response.put("msg", "Medico suspendido correctamente!");
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            response.put("error", e.getMessage());
            return  ResponseEntity.badRequest().body("Error "+ response);
        }
    }
}
