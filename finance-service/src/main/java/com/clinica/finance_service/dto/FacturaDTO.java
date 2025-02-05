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
    //detalles --> Es un array con los id de los turnos que el paciente quiere abonar
    private List<FacturaDetalleDTO> detalles;

}
