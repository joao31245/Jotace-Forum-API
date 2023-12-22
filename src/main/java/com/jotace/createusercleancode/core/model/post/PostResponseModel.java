package com.jotace.createusercleancode.core.model.post;

import com.jotace.createusercleancode.core.entity.post.Post;
import com.jotace.createusercleancode.core.entity.post.PostCategory;
import com.jotace.createusercleancode.core.model.mapper.ImageMapper;

import java.sql.SQLException;

public record PostResponseModel(
        Long postId,
        String title,
        String description,
        byte[] image,
        PostCategory category,
        PostUserResponseModel owner
) {
    public PostResponseModel(Post post) throws SQLException {
        this(post.getId(), post.getTitle(), post.getDescription(), new ImageMapper().blobToByte(post.getImage()),
                post.getCategory(), new PostUserResponseModel(post.getOwner()));
    }
}
