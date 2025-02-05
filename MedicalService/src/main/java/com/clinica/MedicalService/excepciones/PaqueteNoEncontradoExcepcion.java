package com.clinica.MedicalService.Excepciones;

public class PaqueteNoEncontradoExcepcion  extends RuntimeException{

    public PaqueteNoEncontradoExcepcion(String mensaje) {
        super(mensaje);
    }
}
