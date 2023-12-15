package com.jotace.createusercleancode.core.exception;

public class UserIsNullException extends RuntimeException {
    public UserIsNullException(String userIsNull) {
        super(userIsNull);
    }
}
