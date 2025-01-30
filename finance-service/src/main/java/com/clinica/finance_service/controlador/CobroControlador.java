package com.clinica.finance_service.controlador;

import com.clinica.finance_service.DTO.CobroDTO;
import com.clinica.finance_service.Excepciones.CobroNoEncontradoExcepcion;
import com.clinica.finance_service.modelo.Cobro;
import com.clinica.finance_service.servicio.CobroServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cobro")
public class CobroControlador {

    private final CobroServicio cobroServicio;

    @GetMapping
    public ResponseEntity<List<Cobro>> obtenerTodos(){
        List<Cobro> cobroList = cobroServicio.listarTodos();
        return ResponseEntity.ok(cobroList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cobro> obtenerPorId(@PathVariable Long id){
        Cobro cobro = cobroServicio.obtenerPorId(id);
        if(cobro == null) throw new CobroNoEncontradoExcepcion();

        return ResponseEntity.ok(cobro);
    }

    @PostMapping
    public ResponseEntity<Cobro> crear(@RequestBody CobroDTO dto){
        Cobro cobro = cobroServicio.crear(dto);
        return ResponseEntity.created(URI.create("/cobro/" + cobro.getId())).body(cobro);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cobro> actualizar(@PathVariable Long id, @RequestBody CobroDTO dto){
        Cobro cobro = cobroServicio.actualizar(id, dto);
        return ResponseEntity.ok(cobro);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Long id){
        cobroServicio.eliminar(id);
        return ResponseEntity.ok("Se ha eliminado el registro correctamente");

    }

}
