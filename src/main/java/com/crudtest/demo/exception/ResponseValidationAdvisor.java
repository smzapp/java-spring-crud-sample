package com.crudtest.demo.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * We want to change the validation response globally.
 */
@ControllerAdvice
public class ResponseValidationAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<Object> handleDuplicateEntry(DuplicateEntryException ex,
                                         HttpServletRequest request,
                                         HttpServletResponse response) {
        Map<String, String>  messages = new HashMap<>();
        messages.put(ex.getField(), ex.getMessage());

        Map<String, Object> errors = new HashMap<>();
        errors.put("timestamp", new Date());
        errors.put("status", HttpStatus.BAD_REQUEST);
        errors.put("errors", Arrays.asList(messages));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * 400 BAD REQUEST
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request
    ) {
        Map<String, String>  messages = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String field = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            messages.put(field, message);
        });
        Map<String, Object> errors = new HashMap<>();
        errors.put("timestamp", new Date());
        errors.put("status", status.value());
        errors.put("errors", Arrays.asList(messages));
        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }
}
