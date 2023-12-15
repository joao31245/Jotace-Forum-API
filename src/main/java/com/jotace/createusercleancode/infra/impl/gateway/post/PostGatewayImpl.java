package com.jotace.createusercleancode.infra.impl.gateway.post;

import com.jotace.createusercleancode.application.gateway.post.PostGateway;
import com.jotace.createusercleancode.application.model.post.PostUpdateRequestModel;
import com.jotace.createusercleancode.core.entity.post.Post;
import com.jotace.createusercleancode.infra.mapper.post.PostMapper;
import com.jotace.createusercleancode.infra.persistence.post.PostEntityRepository;

public class PostGatewayImpl implements PostGateway {
    private final PostEntityRepository postEntityRepository;
    private final PostMapper postMapper;

    public PostGatewayImpl(PostEntityRepository postEntityRepository, PostMapper postMapper) {
        this.postEntityRepository = postEntityRepository;
        this.postMapper = postMapper;
    }

    @Override
    public Post save(Post post) {
        var postEntity = postMapper.toEntity(post);

        this.postEntityRepository.save(postEntity);

        return postMapper.toAbstract(postEntity);
    }

    @Override
    public Post update(PostUpdateRequestModel postUpdateRequestModel) {
        var post = postEntityRepository.findPostById(postUpdateRequestModel.postId());

        if(postUpdateRequestModel.title() != null) {
            post.setTitle(postUpdateRequestModel.title());
        }

        if(postUpdateRequestModel.description() != null) {
            post.setDescription(postUpdateRequestModel.description());
        }
        var abstractPost = postMapper.toAbstract(post);

        this.save(abstractPost);

        return abstractPost;
    }

}
