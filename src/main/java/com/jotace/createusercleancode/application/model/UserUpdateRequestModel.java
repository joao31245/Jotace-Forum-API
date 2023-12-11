package com.jotace.createusercleancode.application.model;

public record UserUpdateRequestModel(
        Long userId,
        String name,
        String email
) {

}
