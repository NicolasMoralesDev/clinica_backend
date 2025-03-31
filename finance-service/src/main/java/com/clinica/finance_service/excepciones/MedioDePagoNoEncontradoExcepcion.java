package com.clinica.finance_service.excepciones;

public class MedioDePagoNoEncontradoExcepcion extends RuntimeException {
    public MedioDePagoNoEncontradoExcepcion(String message) {
        super(message);
    }
}
