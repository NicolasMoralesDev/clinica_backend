package com.clinica.finance_service.Excepciones;

public class FacturaNoEncontradaExcepcion extends RuntimeException {
    public FacturaNoEncontradaExcepcion(String mensaje) {
        super(mensaje);
    }
}
