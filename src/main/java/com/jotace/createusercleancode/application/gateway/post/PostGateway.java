package com.jotace.createusercleancode.application.gateway.post;

import com.jotace.createusercleancode.application.model.post.PostUpdateRequestModel;
import com.jotace.createusercleancode.core.entity.post.Post;

public interface PostGateway {
    Post save(Post post);

    Post update(PostUpdateRequestModel postUpdateRequestModel);
}
