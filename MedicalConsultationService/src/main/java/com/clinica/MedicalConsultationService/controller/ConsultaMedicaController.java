package com.clinica.MedicalConsultationService.controller;


import com.clinica.MedicalConsultationService.dto.ConsultaMedicaDTO;
import com.clinica.MedicalConsultationService.dto.ConsultaMedicaFiltroDTO;
import com.clinica.MedicalConsultationService.entity.ConsultaMedica;
import com.clinica.MedicalConsultationService.service.IConsultaMedicaSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Clase controller para consultasMedicas
 */
@RestController
@RequestMapping("/api/consultasMedicas")
@CrossOrigin(origins = "*")
public class ConsultaMedicaController {

    @Autowired
    private IConsultaMedicaSerice consultaMedicaService;

    /**
     * Controlador para obtener las consultasMedicas
     * @return ResponseEntity Devuelve esta entidad con el codigo de estado y un listado de consultasMedicas
     */
    @PostMapping(value = "/obtenerTodas")
    public ResponseEntity<?> obtenerConsultasMedicas(@RequestBody ConsultaMedicaFiltroDTO consultaMedicaFiltro){
        try {
            return  ResponseEntity.ok().body(consultaMedicaService.obtenerTodos(consultaMedicaFiltro));
        } catch (Exception e){
            return  ResponseEntity.badRequest().body("Error "+ e.getMessage());
        }
    }

    /**
     * Controlador para obtener una consultaMedica por su id
     * @param id Recibe el id de la consultaMedicas
     * @return ResponseEntity Devuelve esta entidad con la consultaMedica encontrada
     */
    @GetMapping(value = "/obtener")
    public ResponseEntity<?> obtenerConsultaMedicaId(@RequestParam Long id){
        try {
            ConsultaMedica consultasMedicas = consultaMedicaService.obtenerPorId(id);
            return  ResponseEntity.ok().body(consultasMedicas);
        } catch (Exception e){
            return  ResponseEntity.badRequest().body("Error "+ e.getMessage());
        }
    }

    /**
     * Controlador para registrar consultasMedicas
     * @param consultaMedicaDTO Recibe los datos a registrar
     * @return ResponseEntity Devuelve esta entidad con el codigo de estado y un mensaje
     */
    @PostMapping(value = "/registro")
    public ResponseEntity<?> registrarConsultasMedicas(@RequestBody ConsultaMedicaDTO consultaMedicaDTO){
        HashMap<String, String> response = new HashMap<>();

        try {
            consultaMedicaService.crear(consultaMedicaDTO);
            response.put("msg", "Consulta Medica registrada correctamente!");
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            response.put("error", e.getMessage());
            return  ResponseEntity.badRequest().body("Error "+ response);
        }
    }

    /**
     * Controlador para actualizar consultasMedicas
     * @param consultaMedicaDTO Recibe los datos a actualizar
     * @return ResponseEntity Devuelve esta entidad con el codigo de estado y un mensaje
     */
    @PostMapping(value = "/actualizar")
    public ResponseEntity<?> actualizarConsultasMedicas(@RequestBody ConsultaMedicaDTO consultaMedicaDTO){
        HashMap<String, String> response = new HashMap<>();

        try {
            consultaMedicaService.actualizar(consultaMedicaDTO);
            response.put("msg", "Consulta Medica actualizada correctamente!");
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            response.put("error", e.getMessage());
            return  ResponseEntity.badRequest().body("Error "+ response);
        }
    }

    /**
     * Controlador para borrar consultasMedicas
     * @param ids Recibe los ids de las consultaMedicas a borrar
     * @return ResponseEntity Devuelve esta entidad con el codigo de estado y un mensaje
     */
    @PostMapping(value = "/borrar")
    public ResponseEntity<?> borrarConsultaMedica(@RequestBody List<Long> ids){
        HashMap<String, String> response = new HashMap<>();
        try {
            consultaMedicaService.eliminar(ids);
            response.put("msg", "Consulta medica borrada correctamente!");
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            response.put("error", e.getMessage());
            return  ResponseEntity.badRequest().body("Error "+ response);
        }
    }
}
