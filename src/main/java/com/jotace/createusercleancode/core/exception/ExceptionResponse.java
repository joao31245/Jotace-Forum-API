package com.jotace.createusercleancode.core.exception;

public record ExceptionResponse(
        int errorCode,
        String message
) {
}
