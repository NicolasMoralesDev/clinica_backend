package com.clinica.finance_service.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FacturaDetalle {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacturaDetalle;
    @ManyToOne
    @JoinColumn(name = "fk_factura", nullable = false)
    @JsonIgnore
    private Factura factura;
    private Long idTurno;
    private Double precio;
    private Boolean borrado;

}
