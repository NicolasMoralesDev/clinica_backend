package com.clinica.MedicalService.Excepciones;

public class ServicioIndividualNoEncontradaExcepcion extends RuntimeException {

    public ServicioIndividualNoEncontradaExcepcion(String mensaje){
        super(mensaje);
    }
}
