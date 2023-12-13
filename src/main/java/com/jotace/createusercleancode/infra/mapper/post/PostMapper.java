package com.jotace.createusercleancode.infra.mapper.post;

import com.jotace.createusercleancode.core.entity.post.CommonPostFactory;
import com.jotace.createusercleancode.core.entity.post.Post;
import com.jotace.createusercleancode.core.entity.user.CommonUserFactory;
import com.jotace.createusercleancode.infra.persistence.post.PostEntity;

public class PostMapper {
    public PostEntity toEntity(Post post) {

        var postEntity = new PostEntity(post);
        
        return postEntity;
    }

    public Post toAbstract(PostEntity post) {
        var owner = new CommonUserFactory().createUser(post.getOwner().getName(),
                post.getOwner().getPassword(), post.getOwner().getEmail());

        var postAbstract = new CommonPostFactory().create(post.getTitle(),
                post.getImage(), post.getDescription(), owner, post.getPostCategory());

        postAbstract.setId(post.getId());

        return postAbstract;
    }
}
