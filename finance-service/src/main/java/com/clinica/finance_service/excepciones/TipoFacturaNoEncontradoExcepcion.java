package com.clinica.finance_service.excepciones;

public class TipoFacturaNoEncontradoExcepcion extends RuntimeException{

    public TipoFacturaNoEncontradoExcepcion(String message) {
        super(message);
    }
}
