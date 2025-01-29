package com.clinica.MedicalService.controlador;

import com.clinica.MedicalService.DTO.PaqueteDTO;
import com.clinica.MedicalService.Excepciones.PaqueteNoEncontradoExcepcion;
import com.clinica.MedicalService.modelo.Paquete;
import com.clinica.MedicalService.servicio.PaqueteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/paquete")
@RestController
@RequiredArgsConstructor
public class PaqueteControlador {

    private final PaqueteServicio paqueteServicio;

    @GetMapping
    public ResponseEntity<List<Paquete>> obtenerTodos(){
        List<Paquete> paqueteList = paqueteServicio.listarTodos();
        return ResponseEntity.ok(paqueteList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paquete> obtenerPorId(@PathVariable Long id){
        Paquete paquete = paqueteServicio.obtenerPorId(id);
        if(paquete == null) throw new PaqueteNoEncontradoExcepcion("El paquete no existe");
        return ResponseEntity.ok(paquete);
    }

    @PostMapping
    public ResponseEntity<Paquete> crearPaquete(@RequestBody PaqueteDTO dto){
        Paquete paquete = paqueteServicio.crear(dto);
        return ResponseEntity.created(URI.create("/paquete/" + paquete.getIdServicio())).body(paquete);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Paquete> actualizarPaquete(@PathVariable Long id,@RequestBody PaqueteDTO dto){
        Paquete paquete = paqueteServicio.actualizar(id, dto);
        return ResponseEntity.ok(paquete);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPaquete(@PathVariable Long id){
        paqueteServicio.eliminar(id);
        return ResponseEntity.ok("Se elimino el paquete con exito");
    }



}
