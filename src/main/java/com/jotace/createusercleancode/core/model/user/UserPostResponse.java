package com.jotace.createusercleancode.core.model.user;

import com.jotace.createusercleancode.core.entity.post.Post;
import com.jotace.createusercleancode.core.entity.post.PostCategory;
import com.jotace.createusercleancode.core.model.mapper.ImageMapper;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

public record UserPostResponse(
        Long id,
        String title,
        byte[] image,
        String description,
        PostCategory category
) {
    public UserPostResponse(Post post) throws SQLException {
        this(post.getId(), post.getTitle(), new ImageMapper().blobToByte(post.getImage()),
                post.getDescription(), post.getCategory());
    }

}

