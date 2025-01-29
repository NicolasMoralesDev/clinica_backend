package com.clinica.MedicalService.controlador;

import com.clinica.MedicalService.DTO.ServicioIndividualDTO;
import com.clinica.MedicalService.Excepciones.ServicioIndividualNoEncontradaExcepcion;
import com.clinica.MedicalService.modelo.ServicioIndividual;
import com.clinica.MedicalService.servicio.ServicioIndividualServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("servicio-individual")
public class ServicioIndividualControlador {

    private final ServicioIndividualServicio servicioIndividualServicio;

    @GetMapping
    public ResponseEntity<List<ServicioIndividual>> obtenerTodos(){
        List<ServicioIndividual> servicioIndividualList = servicioIndividualServicio.listarTodos();
        return ResponseEntity.ok(servicioIndividualList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicioIndividual> obtenerPorId(@PathVariable Long id){
        ServicioIndividual servicioIndividual = servicioIndividualServicio.obtenerPorId(id);
        if( servicioIndividual == null ) throw new ServicioIndividualNoEncontradaExcepcion("El servicio no existe");
        return ResponseEntity.ok(servicioIndividual);
    }

    @PostMapping
    public ResponseEntity<ServicioIndividual> crearServicioIndividual(@RequestBody ServicioIndividualDTO dto){
        ServicioIndividual servicioIndividual = servicioIndividualServicio.crear(dto);
        return ResponseEntity.created(URI.create("/servicio-individual" + servicioIndividual.getIdServicio())).body(servicioIndividual);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ServicioIndividual> actualizarServicioIndividual(@PathVariable Long id, @RequestBody ServicioIndividualDTO dto){
        ServicioIndividual servicioIndividualActualizado = servicioIndividualServicio.actualizar(id, dto);
        return ResponseEntity.created(URI.create("/servicio-individual/" +
                servicioIndividualActualizado.getIdServicio())).body(servicioIndividualActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarServicioIndividual(@PathVariable Long id){
        servicioIndividualServicio.eliminar(id);
        return ResponseEntity.ok("Se ha eliminado el servicio correctamente");
    }

}
