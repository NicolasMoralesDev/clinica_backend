package com.clinica.MedicalService.excepciones;

public class ServicioIndividualNoEncontradaExcepcion extends RuntimeException {

    public ServicioIndividualNoEncontradaExcepcion(String mensaje){
        super(mensaje);
    }
}
