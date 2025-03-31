package com.clinica.MedicalService.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaError {

    private String codigoError;
    private String mensajeError;

}
