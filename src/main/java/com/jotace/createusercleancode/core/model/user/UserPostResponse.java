package com.jotace.createusercleancode.core.model.user;

import com.jotace.createusercleancode.core.entity.post.Post;
import com.jotace.createusercleancode.core.entity.post.PostCategory;

import java.util.List;

public record UserPostResponse(
        Long id,
        String title,
        String image,
        String description,
        PostCategory category
) {
    public UserPostResponse(Post post) {
        this(post.getId(), post.getTitle(), post.getImage(), post.getDescription(), post.getCategory());
    }

}

