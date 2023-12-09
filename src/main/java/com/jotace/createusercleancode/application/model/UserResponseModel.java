package com.jotace.createusercleancode.application.model;

import com.jotace.createusercleancode.core.entity.User;

import java.time.LocalDateTime;

public record UserResponseModel(
        String name,
        LocalDateTime creationTIme
) {
    public UserResponseModel(User user) {
        this(user.getName(), LocalDateTime.now());
    }
}
