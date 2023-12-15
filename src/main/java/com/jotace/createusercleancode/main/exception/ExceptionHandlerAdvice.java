package com.jotace.createusercleancode.main.exception;

import com.jotace.createusercleancode.core.exception.EmailAlreadyExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(errors.stream().map(ValidationDataError::new).toList());

    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity emailAlreadyExists(EmailAlreadyExistsException ex) {
        return ResponseEntity.badRequest().body("Email already exists");
    }



    private record ValidationDataError(String field, String message) {
        public ValidationDataError(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }

    }
}




