package com.clinica.MedicalService.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaError {

    private String codigoError;
    private String mensajeError;

}
