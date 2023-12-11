package com.jotace.createusercleancode.application.model;

import com.jotace.createusercleancode.core.entity.User;

import java.time.LocalDateTime;

public record UserResponseModel(
        Long id,
        String name,
        LocalDateTime creationTIme,
        String email
) {
    public UserResponseModel(User user) {
        this(user.getId(), user.getName(), LocalDateTime.now(), user.getEmail());
    }

}
