package com.crudtest.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

/**
 * We want to change the validation response globally.
 */
@ControllerAdvice
public class ResponseValidationAdvisor extends ResponseEntityExceptionHandler {

    Map<String, String>  messages = new HashMap<>();

    /**
     * Customize response validation
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String field = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            messages.put(field, message);
        });
        Map<String, Object> errors = new HashMap<>();
        errors.put("timestamp", new Date());
        errors.put("status", status.value());
        errors.put("errors", messages);
        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }
}
