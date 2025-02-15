package com.clinica.finance_service.controlador;


import com.clinica.finance_service.dto.TipoFacturaDTO;
import com.clinica.finance_service.Excepciones.TipoFacturaNoEncontradoExcepcion;
import com.clinica.finance_service.modelo.TipoFactura;
import com.clinica.finance_service.servicio.TipoFacturaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tipofactura")
@RequiredArgsConstructor
public class TipoFacturaControlador {

    private final TipoFacturaServicio tipoFacturaServicio;

    @GetMapping
    public ResponseEntity<List<TipoFactura>> obtenerTodos(){
        List<TipoFactura> tipoFacturaList = tipoFacturaServicio.listarTodos();
        return ResponseEntity.ok(tipoFacturaList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoFactura> obtenerPorId(@PathVariable Long id){
        TipoFactura tipoFactura = tipoFacturaServicio.obtenerPorId(id);
        if(tipoFactura == null ) throw new TipoFacturaNoEncontradoExcepcion("El TipoFactura no existe");
        return ResponseEntity.ok(tipoFactura);
    }

    @PostMapping()
    public ResponseEntity<TipoFactura> crear(@RequestBody TipoFacturaDTO dto){
        TipoFactura tipoFactura = tipoFacturaServicio.crear(dto);
        return ResponseEntity.created(URI.create("/tipofactura/" + tipoFactura.getIdTipoFactura())).body(tipoFactura);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TipoFactura> actualizar(@PathVariable Long id, @RequestBody TipoFacturaDTO dto){
        TipoFactura tipoFactura = tipoFacturaServicio.actualizar(id, dto);
        return ResponseEntity.ok(tipoFactura);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id){
        tipoFacturaServicio.eliminar(id);
        return ResponseEntity.ok("Se ha eliminado el registro correctamente");
    }




}
