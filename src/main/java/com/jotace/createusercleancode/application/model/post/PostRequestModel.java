package com.jotace.createusercleancode.application.model.post;

import com.jotace.createusercleancode.core.entity.post.PostCategory;

public record PostRequestModel(
        Long ownerId,
        String title,
        String description,
        String image,
        PostCategory postCategory
) {


}
