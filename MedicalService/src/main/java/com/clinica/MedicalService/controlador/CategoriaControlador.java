package com.clinica.MedicalService.controlador;

import com.clinica.MedicalService.DTO.CategoriaDTO;
import com.clinica.MedicalService.Excepciones.CategoriaNoEncontradaExcepcion;
import com.clinica.MedicalService.modelo.Categoria;
import com.clinica.MedicalService.servicio.CategoriaServicio;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categoria")
public class CategoriaControlador {

    private final CategoriaServicio categoriaServicio;


    @GetMapping
    public ResponseEntity<List<Categoria>> obtenerTodasLasCategorias(){
        List<Categoria> categoriaList = categoriaServicio.listarTodos();
        return ResponseEntity.ok(categoriaList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerCategoriaPorId(@PathVariable Long id){
        Categoria categoria = categoriaServicio.obtenerPorId(id);
        if(categoria == null) throw new CategoriaNoEncontradaExcepcion("La categoria no existe");
        return ResponseEntity.ok(categoria);
    }

    //Falta agregar validacion de campos vacios y registros duplicados en el metodo del servicio
    @PostMapping
    public ResponseEntity<Categoria> crearCategoria(@RequestBody CategoriaDTO dto){
        Categoria categoria = categoriaServicio.crear(dto);
        return ResponseEntity.created(URI.create("/categorias/" + categoria.getIdCategoria())).body(categoria);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO dto){
        Categoria categoriaActualizada = categoriaServicio.actualizar(id, dto);
        return ResponseEntity.ok(categoriaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable Long id){
        categoriaServicio.eliminar(id);
        return ResponseEntity.ok("Categoria eliminada correctamente");
    }







}
