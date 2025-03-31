package com.clinica.finance_service.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedioDePago {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedioDePago;
    private String nombre;
    private Double incremento;
    private Boolean borrado;

}
