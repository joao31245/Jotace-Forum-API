package com.jotace.createusercleancode.core.model.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthRequestModel(
        @Email
        @NotBlank
        String email,
        @NotBlank
        String password
) {
}
