package com.clinica.finance_service.Excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import com.clinica.finance_service.DTO.RespuestaError;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Clase global para el manejo de excepciones en toda la aplicacion.
 *
 * Uso:
 * Cuando una excepcion personalizada es lanzada, el manejador captura la misma y devuelve un objeto como {@link TipoFacturaNoEncontradoExcepcion},
 * el manejador captura esta excepcion y devuelve un objeto {@link RespuestaError}, con un mensaje descriptivo.
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RespuestaError> handleExcepcionGeneral(Exception ex){
        RespuestaError respuesta = new RespuestaError("ERROR_GENERAL", ex.getMessage());
        return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TipoFacturaNoEncontradoExcepcion.class)
    public ResponseEntity<RespuestaError> handleTipoFacturaNoEncontradoException(TipoFacturaNoEncontradoExcepcion ex){
        RespuestaError respuesta = new RespuestaError("TIPO_FACTURA_NO_ENCONTRADA", ex.getMessage());
        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MedioDePagoNoEncontradoExcepcion.class)
    public ResponseEntity<RespuestaError> handleMedioDePagoNoEncontradoException(MedioDePagoNoEncontradoExcepcion ex){
        RespuestaError respuesta = new RespuestaError("MEDIO_DE_PAGO_NO_ENCONTRADO", ex.getMessage());
        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FacturaNoEncontradaExcepcion.class)
    public ResponseEntity<RespuestaError> handleFacturaNoEncontradaException(FacturaNoEncontradaExcepcion ex){
        RespuestaError respuesta = new RespuestaError("FACTURA_NO_ENCONTRADA", ex.getMessage());
        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }

}
