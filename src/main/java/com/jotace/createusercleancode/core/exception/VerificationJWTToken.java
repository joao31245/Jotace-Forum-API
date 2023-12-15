package com.jotace.createusercleancode.core.exception;

public class VerificationJWTToken extends RuntimeException{
    public VerificationJWTToken(String failWhileVerifyPost) {
        super(failWhileVerifyPost);
    }
}
