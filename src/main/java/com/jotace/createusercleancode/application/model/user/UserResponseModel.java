package com.jotace.createusercleancode.application.model.user;

import com.jotace.createusercleancode.core.entity.user.User;

import java.time.LocalDateTime;
import java.util.List;

public record UserResponseModel(
        Long id,
        String name,
        LocalDateTime creationTIme,
        String email,
        List<UserPostResponse> userPostResponse
) {
    public UserResponseModel(User user) {
        this(user.getId(), user.getName(), LocalDateTime.now(), user.getEmail(),
                user.getPosts().stream().map(UserPostResponse::new).toList());
    }

}
