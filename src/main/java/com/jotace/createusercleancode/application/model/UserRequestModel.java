package com.jotace.createusercleancode.application.model;

import java.time.LocalDateTime;

public record UserRequestModel(
        String name,
        String password,
        String email,
        LocalDateTime creationTIme
) {
}
