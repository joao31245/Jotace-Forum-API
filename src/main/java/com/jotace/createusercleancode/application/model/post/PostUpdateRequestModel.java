package com.jotace.createusercleancode.application.model.post;

public record PostUpdateRequestModel(
        Long postId,
        String title,
        String description

) {

}
