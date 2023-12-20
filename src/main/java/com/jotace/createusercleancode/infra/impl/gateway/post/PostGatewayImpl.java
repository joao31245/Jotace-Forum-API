package com.jotace.createusercleancode.infra.impl.gateway.post;

import com.jotace.createusercleancode.application.gateway.post.PostGateway;
import com.jotace.createusercleancode.core.model.post.PostUpdateRequestModel;
import com.jotace.createusercleancode.core.entity.post.Post;
import com.jotace.createusercleancode.core.exception.PostIsNullException;
import com.jotace.createusercleancode.infra.mapper.post.PostMapper;
import com.jotace.createusercleancode.infra.persistence.post.PostEntityRepository;

import java.util.ArrayList;
import java.util.List;

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
        try {
            var post = postEntityRepository.findPostById(postUpdateRequestModel.postId());

            if(postUpdateRequestModel.title() != null) {
                post.setTitle(postUpdateRequestModel.title());
            }

            if(postUpdateRequestModel.description() != null) {
                post.setDescription(postUpdateRequestModel.description());
            }

            this.postEntityRepository.save(post);

            var abstractPost = postMapper.toAbstract(post);


            return abstractPost;

        } catch (NullPointerException exception) {
            throw new PostIsNullException("Post is null");
        }

    }

    @Override
    public Post findPostById(Long id) {
        try {
            var post = postEntityRepository.findPostById(id);
            return postMapper.toAbstract(post);
        } catch (NullPointerException exception) {
            throw new PostIsNullException("Post is null");
        }
    }

    @Override
    public void delete(Long id) {
        postEntityRepository.deleteById(id);
    }

    @Override
    public List<Post> getAllPosts() {
        var listPosts = postEntityRepository.findAll();

        var abstractPosts = new ArrayList<Post>();

        listPosts.forEach(postEntity -> {
            abstractPosts.add(postMapper.toAbstract(postEntity));
        });

        return abstractPosts;
    }

}
