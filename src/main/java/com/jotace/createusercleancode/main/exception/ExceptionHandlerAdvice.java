package com.jotace.createusercleancode.main.exception;

import com.jotace.createusercleancode.core.exception.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.JwtValidationException;
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

    @ExceptionHandler(UserIsNullException.class)
    public ResponseEntity<ExceptionResponse> userIsNull(UserIsNullException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage()));
    }

    @ExceptionHandler(PostIsNullException.class)
    public ResponseEntity<ExceptionResponse> postIsNull(PostIsNullException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage()));
    }

    @ExceptionHandler(CreateJWTTokenException.class)
    public ResponseEntity<ExceptionResponse> createJwtError(CreateJWTTokenException exception) {
        return ResponseEntity.internalServerError().body(new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage()));
    }



    @ExceptionHandler(JwtValidationException.class)
    public ResponseEntity<ExceptionResponse> validateJwtError(JwtValidationException exception) {
        return ResponseEntity.internalServerError().body(new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage()));
    }

    private record ValidationDataError(String field, String message) {
        public ValidationDataError(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }

    }
}




