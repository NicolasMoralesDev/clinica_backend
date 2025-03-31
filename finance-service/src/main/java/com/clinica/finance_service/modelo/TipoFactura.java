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
@AllArgsConstructor
@NoArgsConstructor
public class TipoFactura {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoFactura;
    private String nombre;
    private Boolean borrado;



}
