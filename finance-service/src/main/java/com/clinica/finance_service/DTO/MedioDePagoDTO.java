package com.clinica.finance_service.DTO;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedioDePagoDTO {

    private String nombre;
    private Double incremento;

}
