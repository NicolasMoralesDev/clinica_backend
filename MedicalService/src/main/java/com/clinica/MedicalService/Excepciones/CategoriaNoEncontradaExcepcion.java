package com.clinica.MedicalService.Excepciones;

public class CategoriaNoEncontradaExcepcion extends RuntimeException {

    public CategoriaNoEncontradaExcepcion(String mensaje){
        super(mensaje);
    }
}
