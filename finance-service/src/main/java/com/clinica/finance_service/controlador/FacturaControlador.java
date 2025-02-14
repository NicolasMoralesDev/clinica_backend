package com.clinica.finance_service.controlador;

import com.clinica.finance_service.dto.FacturaDTO;
import com.clinica.finance_service.Excepciones.FacturaNoEncontradaExcepcion;
import com.clinica.finance_service.modelo.Factura;
import com.clinica.finance_service.servicio.FacturaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/factura")
public class FacturaControlador {

    private final FacturaServicio facturaServicio;

    @GetMapping
    public ResponseEntity<List<Factura>> obtenerTodas(){
        List<Factura> facturaList = facturaServicio.listarTodos();
        return ResponseEntity.ok(facturaList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> obtenerPorId(@PathVariable Long id){
        Factura factura = facturaServicio.obtenerPorId(id);
        if(factura == null) throw new FacturaNoEncontradaExcepcion("La factura no existe");
        return ResponseEntity.ok(factura);
    }

    @PostMapping
    public ResponseEntity<Factura> crear(@RequestBody FacturaDTO dto){
        Factura factura = facturaServicio.crear(dto);
        return ResponseEntity.created(URI.create("/factura/" + factura.getIdFactura())).body(factura);
    }


}
