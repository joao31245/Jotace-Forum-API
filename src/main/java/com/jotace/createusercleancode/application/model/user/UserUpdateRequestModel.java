package com.jotace.createusercleancode.application.model.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserUpdateRequestModel(
        @NotNull
        Long userId,
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email
) {

}
