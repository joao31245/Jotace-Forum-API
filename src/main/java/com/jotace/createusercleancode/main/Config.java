package com.jotace.createusercleancode.main;

import com.jotace.createusercleancode.application.gateway.post.FindUserGateway;
import com.jotace.createusercleancode.application.boundary.post.PostInputBoundary;
import com.jotace.createusercleancode.application.boundary.user.UserInputBoundary;
import com.jotace.createusercleancode.application.gateway.post.PostGateway;
import com.jotace.createusercleancode.application.gateway.user.UserGateway;
import com.jotace.createusercleancode.application.presenter.post.CreatePostPresenter;
import com.jotace.createusercleancode.application.presenter.user.CreateUserPresenter;
import com.jotace.createusercleancode.application.presenter.user.UpdateUserPresenter;
import com.jotace.createusercleancode.application.usecases.post.PostInteractor;
import com.jotace.createusercleancode.application.usecases.user.UserInteractor;
import com.jotace.createusercleancode.infra.impl.gateway.post.FindUserGatewayImpl;
import com.jotace.createusercleancode.infra.impl.gateway.post.PostGatewayImpl;
import com.jotace.createusercleancode.infra.impl.gateway.user.UserGatewayImpl;
import com.jotace.createusercleancode.infra.impl.presenter.post.CreatePostPresenterImpl;
import com.jotace.createusercleancode.infra.impl.presenter.user.CreateUserPresenterImpl;
import com.jotace.createusercleancode.infra.impl.presenter.user.UpdateUserPresenterImpl;
import com.jotace.createusercleancode.infra.mapper.post.PostMapper;
import com.jotace.createusercleancode.infra.mapper.user.UserMapper;
import com.jotace.createusercleancode.infra.persistence.UserEntityRepository;
import com.jotace.createusercleancode.infra.persistence.post.PostEntityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    UserInputBoundary userInputBoundary(UserInteractor userInteractor) {
        return userInteractor;
    }

    @Bean
    UserInteractor createUserInteractor(UserGateway registerUserGateway,
                                        CreateUserPresenter createUserPresenter,
                                        UpdateUserPresenter updateUserPresenter) {
        return new UserInteractor(registerUserGateway, createUserPresenter, updateUserPresenter);
    }

    @Bean
    UserGateway registerUserGateway(UserGatewayImpl registerUser) {
        return registerUser;
    }

    @Bean
    UserGatewayImpl registerUser(UserEntityRepository repository, UserMapper userMapper) {
        return new UserGatewayImpl(repository, userMapper);
    }

    @Bean
    UserMapper userMapper() {
        return new UserMapper();
    }

    @Bean
    CreateUserPresenter createUserPresenter(CreateUserPresenterImpl createUserPresenter) {
        return createUserPresenter;
    }

    @Bean
    CreateUserPresenterImpl createUserPresenterImpl() {
        return new CreateUserPresenterImpl();
    }

    @Bean
    UpdateUserPresenter updateUserPresenter() {
        return new UpdateUserPresenterImpl();
    }

    @Bean
    UpdateUserPresenterImpl updateUserPresenterImpl() {
        return new UpdateUserPresenterImpl();
    }

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
