package com.jotace.createusercleancode.core.model.post;

import com.jotace.createusercleancode.core.entity.post.Post;

public record PostUpdateResponseModel(
        String title,
        String description
) {
    public PostUpdateResponseModel(Post post) {
        this(post.getTitle(), post.getDescription());
    }
}
