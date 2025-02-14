package com.clinica.finance_service.Excepciones;

public class TipoFacturaNoEncontradoExcepcion extends RuntimeException{

    public TipoFacturaNoEncontradoExcepcion(String message) {
        super(message);
    }
}
