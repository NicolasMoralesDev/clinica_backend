package com.clinica.finance_service.Excepciones;

import org.springframework.stereotype.Component;

@Component
public class CobroNoEncontradoExcepcion extends RuntimeException{

    public CobroNoEncontradoExcepcion() {
        super("El cobro no existe");
    }
}
