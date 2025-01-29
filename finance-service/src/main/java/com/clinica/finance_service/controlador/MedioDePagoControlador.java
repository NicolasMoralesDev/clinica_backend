package com.clinica.finance_service.controlador;

import com.clinica.finance_service.DTO.MedioDePagoDTO;
import com.clinica.finance_service.Excepciones.MedioDePagoNoEncontradoExcepcion;
import com.clinica.finance_service.modelo.MedioDePago;
import com.clinica.finance_service.servicio.MedioDePagoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mediodepago")
public class MedioDePagoControlador {

    private final MedioDePagoServicio medioDePagoServicio;

    @GetMapping
    public ResponseEntity<List<MedioDePago>> obtenerTodos(){
        List<MedioDePago> medioDePagoList = medioDePagoServicio.listarTodos();
        return ResponseEntity.ok(medioDePagoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedioDePago> obtenerPorId(@PathVariable Long id ){
        MedioDePago medioDePago = medioDePagoServicio.obtenerPorId(id);
        if(medioDePago == null) throw new MedioDePagoNoEncontradoExcepcion("El medio de pago no existe");
        return ResponseEntity.ok(medioDePago);
    }

    @PostMapping()
    public ResponseEntity<MedioDePago> crear(@RequestBody MedioDePagoDTO dto) {
        MedioDePago medioDePago = medioDePagoServicio.crear(dto);
        return ResponseEntity.created(URI.create("/mediodepago/" + medioDePago.getIdMedioDePago())).body(medioDePago);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MedioDePago> actualizar(@PathVariable Long id, @RequestBody MedioDePagoDTO dto){
        MedioDePago medioDePago = medioDePagoServicio.actualizar(id, dto);
        return ResponseEntity.ok(medioDePago);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id){
        medioDePagoServicio.eliminar(id);
        return ResponseEntity.ok("Se ha eliminado el registro correctamente");
    }





}
