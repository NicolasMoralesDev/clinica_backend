package com.clinica.finance_service.Excepciones;

public class MedioDePagoNoEncontradoExcepcion extends RuntimeException {
    public MedioDePagoNoEncontradoExcepcion(String message) {
        super(message);
    }
}
