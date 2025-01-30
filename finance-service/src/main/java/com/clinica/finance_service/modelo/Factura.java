package com.clinica.finance_service.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Factura {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;

    @ManyToOne
    @JoinColumn(name = "fk_tipo_factura")
    private TipoFactura tipoFactura;

    private Long idPaciente;
    private LocalDate fechaEmision;

    @OneToMany
    @JoinColumn(name = "fk_medio_pago")
    private MedioDePago medioDePago;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FacturaDetalle> detalles = new ArrayList<>();
    private Boolean pagado;
    private Double total;
    private Boolean borrado;


}
