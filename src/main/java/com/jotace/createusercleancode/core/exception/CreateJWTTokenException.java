package com.jotace.createusercleancode.core.exception;

public class CreateJWTTokenException extends RuntimeException {

    public CreateJWTTokenException(String failWhileCreateToken) {
        super(failWhileCreateToken);
    }
}
