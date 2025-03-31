package com.clinica.finance_service.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cobro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_factura")
    private Factura factura;
    @ManyToOne
    @JoinColumn(name = "fk_medio_de_pago")
    private MedioDePago medioDePago;
    private Double monto;
    private Boolean borrado;
    private Boolean bloqueado;


}
