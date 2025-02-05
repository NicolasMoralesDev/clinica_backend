package com.clinica.finance_service.Excepciones;

import org.springframework.stereotype.Component;

@Component
public class CobroBorradoExcepcion extends RuntimeException {
    public CobroBorradoExcepcion() {
        super("El cobro se encuentra borrado y no puede modificarse");
    }
}
