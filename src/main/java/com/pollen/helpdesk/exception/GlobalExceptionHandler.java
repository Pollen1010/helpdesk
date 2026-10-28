package com.pollen.helpdesk.exception;

//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>>
    handleValidationException(
            MethodArgumentNotValidException ex) {

        String message = ex.getBindingResult()
                .getFieldError()
                .getDefaultMessage();

        return ResponseEntity.badRequest()
                .body(Map.of(
                        "message",
                        message
                ));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Map<String, String>>
    handleBusinessException(
            BusinessException ex) {

        return ResponseEntity.badRequest()
                .body(Map.of(
                        "message",
                        ex.getMessage()
                ));
    }
}