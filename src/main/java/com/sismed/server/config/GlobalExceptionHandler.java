package com.sismed.server.config;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


//TODO Implementa un manejador de excepciones global para capturar la excepción DataIntegrityViolationException y devolver un mensaje de error amigable al usuario.

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        // Aquí puedes personalizar el mensaje de error que deseas devolver al usuario
        String mensajeError = "El nombre de usuario ya existe en el sistema. Por favor, elige otro nombre de usuario.";

        // Devuelve una respuesta de error con un mensaje amigable
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensajeError);
    }
}
