package com.clinica.MedicalService.excepciones;

public class PaqueteNoEncontradoExcepcion  extends RuntimeException{

    public PaqueteNoEncontradoExcepcion(String mensaje) {
        super(mensaje);
    }
}
