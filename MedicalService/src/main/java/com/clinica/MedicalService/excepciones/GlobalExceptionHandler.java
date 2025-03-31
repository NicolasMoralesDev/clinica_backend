package com.clinica.MedicalService.excepciones;

import com.clinica.MedicalService.dto.RespuestaError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Clase global para el manejo de excepciones en toda la aplicacion.
 *
 * Uso:
 * Cuando una excepcion personalizada es lanzada, el manejador captura la misma y devuelve un objeto como {@link com.clinica.MedicalService.Excepciones.CategoriaNoEncontradaExcepcion},
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

    @ExceptionHandler(com.clinica.MedicalService.excepciones.CategoriaNoEncontradaExcepcion.class)
    public ResponseEntity<RespuestaError> handleCategoriaNoEncontradaExcepcion(com.clinica.MedicalService.excepciones.CategoriaNoEncontradaExcepcion ex){
        RespuestaError respuesta =new RespuestaError("CATEGORIA_NO_ENCONTRADA", ex.getMessage());
        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(com.clinica.MedicalService.excepciones.ServicioIndividualNoEncontradaExcepcion.class)
    public ResponseEntity<RespuestaError> handleServicioNoEncontrado(com.clinica.MedicalService.excepciones.ServicioIndividualNoEncontradaExcepcion ex){
        RespuestaError respuesta = new RespuestaError("SERVICIO_IND_NO_ENCONTRADO", ex.getMessage());
        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(com.clinica.MedicalService.excepciones.PaqueteNoEncontradoExcepcion.class)
    public ResponseEntity<RespuestaError> handlePaqueteNoEncontrado(com.clinica.MedicalService.excepciones.PaqueteNoEncontradoExcepcion ex){
        RespuestaError respuesta = new RespuestaError("PAQUETE_NO_ENCONTRADO", ex.getMessage());
        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }





}
