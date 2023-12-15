package com.jotace.createusercleancode.main.config.post;

import com.jotace.createusercleancode.core.boundary.post.PostInputBoundary;
import com.jotace.createusercleancode.application.gateway.post.FindUserGateway;
import com.jotace.createusercleancode.application.gateway.post.PostGateway;
import com.jotace.createusercleancode.application.presenter.post.CreatePostPresenter;
import com.jotace.createusercleancode.application.usecases.post.PostInteractor;
import com.jotace.createusercleancode.infra.impl.gateway.post.FindUserGatewayImpl;
import com.jotace.createusercleancode.infra.impl.gateway.post.PostGatewayImpl;
import com.jotace.createusercleancode.infra.impl.presenter.post.CreatePostPresenterImpl;
import com.jotace.createusercleancode.infra.mapper.post.PostMapper;
import com.jotace.createusercleancode.infra.mapper.user.UserMapper;
import com.jotace.createusercleancode.infra.persistence.post.PostEntityRepository;
import com.jotace.createusercleancode.infra.persistence.user.UserEntityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostConfig {
    @Bean
    PostInputBoundary postInputBoundary(PostGateway postGateway,
                                        CreatePostPresenter createPostPresenter, FindUserGateway findUserGateway) {
        return new PostInteractor(postGateway, createPostPresenter, findUserGateway);
    }

    @Bean
    PostGateway postGateway(PostEntityRepository postEntityRepository, PostMapper postMapper) {
        return new PostGatewayImpl(postEntityRepository, postMapper);
    }

    @Bean
    PostMapper postMapper() {
        return new PostMapper();
    }

    @Bean
    CreatePostPresenter createPostPresenter() {
        return new CreatePostPresenterImpl();
    }
    @Bean
    FindUserGateway findUserGateway(UserEntityRepository userEntityRepository, UserMapper userMapper) {
        return new FindUserGatewayImpl(userEntityRepository, userMapper);
    }
}
