package com.jotace.createusercleancode.core.model.user;

import com.jotace.createusercleancode.core.entity.user.User;
import com.jotace.createusercleancode.core.model.mapper.ImageMapper;

import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public record UserResponseModel(
        Long id,
        String name,
        LocalDateTime creationTIme,
        String email,
        List<UserPostResponse> userPostResponse,
        byte[] image
) {
    public UserResponseModel(User user) throws SQLException {
        this(user.getId(), user.getName(), LocalDateTime.now(), user.getEmail(),
                user.getPosts().stream().map(post -> {
                    try {
                        return new UserPostResponse(post);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }).toList(), new ImageMapper().blobToByte(user.getImage()));
    }

}
