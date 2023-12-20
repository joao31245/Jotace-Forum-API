package com.jotace.createusercleancode.core.model.post;

public record PostUpdateRequestModel(
        Long postId,
        String title,
        String description

) {

}
