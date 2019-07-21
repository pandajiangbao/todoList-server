package com.thoughtworks.parking_lot.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = FullCarException.class)
    private static ResponseEntity globalExceptionHandle(FullCarException e) {
        return ResponseEntity.badRequest().body("停车场已经满");
    }
}