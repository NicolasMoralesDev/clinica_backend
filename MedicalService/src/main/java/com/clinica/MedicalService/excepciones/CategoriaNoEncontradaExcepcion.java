package com.clinica.MedicalService.excepciones;

public class CategoriaNoEncontradaExcepcion extends RuntimeException {

    public CategoriaNoEncontradaExcepcion(String mensaje){
        super(mensaje);
    }
}
