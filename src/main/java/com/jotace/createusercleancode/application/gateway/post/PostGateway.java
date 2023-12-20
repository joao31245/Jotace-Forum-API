package com.jotace.createusercleancode.application.gateway.post;

import com.jotace.createusercleancode.core.model.post.PostUpdateRequestModel;
import com.jotace.createusercleancode.core.entity.post.Post;

import java.util.List;

public interface PostGateway {
    Post save(Post post);
    Post update(PostUpdateRequestModel postUpdateRequestModel);
    Post findPostById(Long id);
    void delete(Long id);
    List<Post> getAllPosts();
}
