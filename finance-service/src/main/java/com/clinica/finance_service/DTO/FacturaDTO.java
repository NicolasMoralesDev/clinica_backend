package com.clinica.finance_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacturaDTO {


    private Long tipoFactura;
    private Long idPaciente;
    private Long medioDePago;
    private List<FacturaDetalleDTO> detalles;

}
