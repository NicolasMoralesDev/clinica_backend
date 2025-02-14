package com.clinica.finance_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CobroDTO {

    Long factura;
    Long medioDePago;
    Double monto;


}