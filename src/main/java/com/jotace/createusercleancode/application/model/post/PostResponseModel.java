package com.jotace.createusercleancode.application.model.post;

import com.jotace.createusercleancode.core.entity.post.PostCategory;

public record PostResponseModel(
        Long ownerId,
        Long userId,
        String title,
        String description,
        String image,
        PostCategory category
) {



}
