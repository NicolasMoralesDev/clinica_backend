package com.clinica.finance_service.excepciones;

import org.springframework.stereotype.Component;

@Component
public class FacturaPagadaExcepcion extends RuntimeException{

    public FacturaPagadaExcepcion() {
        super("La factura ya se encuentra debitada y no puede modificarse ni se pueden agregar cobros");
    }
}
