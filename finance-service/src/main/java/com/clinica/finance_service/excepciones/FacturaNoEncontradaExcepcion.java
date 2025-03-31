package com.clinica.finance_service.excepciones;

public class FacturaNoEncontradaExcepcion extends RuntimeException {
    public FacturaNoEncontradaExcepcion(String mensaje) {
        super(mensaje);
    }
}
