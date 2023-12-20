package com.jotace.createusercleancode.core.model.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record UserRequestModel(
        @NotBlank
        String name,
        @NotBlank
        String password,
        @Email
        @NotBlank
        String email,
        LocalDateTime creationTIme
) {
}
