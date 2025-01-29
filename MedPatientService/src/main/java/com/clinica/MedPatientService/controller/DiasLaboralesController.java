package com.clinica.MedPatientService.controller;

import com.clinica.MedPatientService.dto.DiaLaboralDTO;
import com.clinica.MedPatientService.entity.DiaLaboral;
import com.clinica.MedPatientService.service.IDiasLaboralesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


/**
 * Clase controller para DíasLaborales
 */
@RestController
@RequestMapping("/api/dias-laborales")
@CrossOrigin(origins = "*")
public class DiasLaboralesController {

    @Autowired
    private IDiasLaboralesService diasLaboralesService;

    /**
     * Controlador para obtener los díasLaborales
     * @return ResponseEntity Devuelve esta entidad con el codigo de estado y un listado de diasLaborales
     */
    @GetMapping(value = "/obtenerTodas")
    public ResponseEntity<?> obtenerDiasLaborales(){
        try {
            List<DiaLaboral> diaLaborales = diasLaboralesService.obtenerTodos();
            return  ResponseEntity.ok().body(diaLaborales);
        } catch (Exception e){
            return  ResponseEntity.badRequest().body("Error "+ e.getMessage());
        }
    }

    /**
     * Controlador para obtener un díaLaboral por su id
     * @param id Recibe el id del diaLaboral
     * @return ResponseEntity Devuelve esta entidad con el díaLaboral encontrado
     */
    @GetMapping(value = "/obtener")
    public ResponseEntity<?> obtenerDiaLaboralPorId(@RequestParam Long id){
        try {
            DiaLaboral diaLaboral = diasLaboralesService.obtenerPorId(id);
            return  ResponseEntity.ok().body(diaLaboral);
        } catch (Exception e){
            return  ResponseEntity.badRequest().body("Error "+ e.getMessage());
        }
    }

    /**
     * Controlador para registrar díasLaborales
     * @param diaLaboralDTO Recibe los datos a registrar
     * @return ResponseEntity Devuelve esta entidad con el codigo de estado y un mensaje
     */
    @PostMapping(value = "/registro")
    public ResponseEntity<?> registrarDiasLaborales(@RequestBody DiaLaboralDTO diaLaboralDTO){
        HashMap<String, String> response = new HashMap<>();

        try {
            diasLaboralesService.crear(diaLaboralDTO);
            response.put("msg", "Día laboral registrado correctamente!");
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            response.put("error", e.getMessage());
            return  ResponseEntity.badRequest().body("Error "+ response);
        }
    }

    /**
     * Controlador para actualizar díasLaborales
     * @param diaLaboralDTO Recibe los datos a actualizar
     * @return ResponseEntity Devuelve esta entidad con el codigo de estado y un mensaje
     */
    @PostMapping(value = "/actualizar")
    public ResponseEntity<?> actualizarDiaLaboral(@RequestBody DiaLaboralDTO diaLaboralDTO){
        HashMap<String, String> response = new HashMap<>();

        try {
            diasLaboralesService.actualizar(diaLaboralDTO);
            response.put("msg", "Día Laboral actualizado correctamente!");
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            response.put("error", e.getMessage());
            return  ResponseEntity.badRequest().body("Error "+ response);
        }
    }

    /**
     * Controlador para borrar díasLaborales
     * @param id Recibe el id del díaLaboral a borrar
     * @return ResponseEntity Devuelve esta entidad con el codigo de estado y un mensaje
     */
    @DeleteMapping(value = "/borrar")
    public ResponseEntity<?> borrarDiaLaboral(@RequestParam Long id){
        HashMap<String, String> response = new HashMap<>();

        try {
            diasLaboralesService.eliminar(id);
            response.put("msg", "Día Laboral borrado correctamente!");
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            response.put("error", e.getMessage());
            return  ResponseEntity.badRequest().body("Error "+ response);
        }
    }
}
