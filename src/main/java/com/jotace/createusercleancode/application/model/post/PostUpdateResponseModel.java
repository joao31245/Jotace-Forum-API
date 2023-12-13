package com.jotace.createusercleancode.application.model.post;

import com.jotace.createusercleancode.core.entity.post.Post;

public record PostUpdateResponseModel(
        String title,
        String description
) {
    public PostUpdateResponseModel(Post post) {
        this(post.getTitle(), post.getDescription());
    }
}
