package com.clinica.finance_service.excepciones;

import org.springframework.stereotype.Component;

@Component
public class FacturaBorradaExcepcion extends RuntimeException {
    public FacturaBorradaExcepcion() {
        super("La factura se encuentre eliminada y no puede modificarse");
    }
}
