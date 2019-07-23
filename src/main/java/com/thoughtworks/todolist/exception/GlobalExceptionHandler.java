package com.thoughtworks.todolist.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    private static ResponseEntity globalExceptionHandle(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}