package com.clinica.finance_service.excepciones;

import org.springframework.stereotype.Component;

@Component
public class CobroBloqueadoExcepcion extends  RuntimeException{

    public CobroBloqueadoExcepcion() {
        super("El cobro se encuentra bloqueado y no puede modificarse");
    }
}
