package com.jotace.createusercleancode.core.model.post;

import com.jotace.createusercleancode.core.entity.post.Post;
import com.jotace.createusercleancode.core.entity.post.PostCategory;

public record PostResponseModel(
        Long postId,
        String title,
        String description,
        String image,
        PostCategory category,
        PostUserResponseModel owner
) {


    public PostResponseModel(Post post) {
        this(post.getId(), post.getTitle(), post.getDescription(), post.getImage(),
                post.getCategory(), new PostUserResponseModel(post.getOwner()));
    }
}
