package com.jotace.createusercleancode.core.exception;

public class PostIsNullException extends RuntimeException {
    public PostIsNullException(String postIsNull) {
        super(postIsNull);
    }
}
