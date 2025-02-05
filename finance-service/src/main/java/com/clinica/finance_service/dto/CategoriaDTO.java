package com.clinica.finance_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {

    private Long idCategoria;
    private String nombre;
    private String codigoCategoria;
    private Boolean borrado;

}
