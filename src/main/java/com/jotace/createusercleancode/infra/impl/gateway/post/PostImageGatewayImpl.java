package com.jotace.createusercleancode.infra.impl.gateway.post;

import com.jotace.createusercleancode.application.gateway.post.PostImageGateway;
import com.jotace.createusercleancode.infra.mapper.post.PostMapper;
import com.jotace.createusercleancode.infra.persistence.post.PostEntityRepository;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;

public class PostImageGatewayImpl implements PostImageGateway {
    private final PostEntityRepository postEntityRepository;
    private final PostMapper postMapper;

    public PostImageGatewayImpl(PostEntityRepository postEntityRepository, PostMapper postMapper) {
        this.postEntityRepository = postEntityRepository;
        this.postMapper = postMapper;
    }

    @Override
    public Blob setImage(Long id, SerialBlob image) {
        var post = postEntityRepository.findPostById(id);

        post.setImage(image);

        postEntityRepository.save(post);

        return  postMapper.toAbstract(post).getImage();
    }
}
