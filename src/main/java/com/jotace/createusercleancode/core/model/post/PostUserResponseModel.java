package com.jotace.createusercleancode.core.model.post;

import com.jotace.createusercleancode.core.entity.user.User;

public record PostUserResponseModel(
        String name,
        String email
) {
    public PostUserResponseModel(User user) {
        this(user.getName(), user.getEmail());
    }
}
