package com.jotace.createusercleancode.main.config.user;

import com.jotace.createusercleancode.core.boundary.user.UserInputBoundary;
import com.jotace.createusercleancode.application.gateway.user.UserGateway;
import com.jotace.createusercleancode.application.presenter.user.CreateUserPresenter;
import com.jotace.createusercleancode.application.presenter.user.UpdateUserPresenter;
import com.jotace.createusercleancode.application.usecases.user.UserInteractor;
import com.jotace.createusercleancode.infra.impl.gateway.user.crud.UserGatewayImpl;
import com.jotace.createusercleancode.infra.impl.presenter.user.CreateUserPresenterImpl;
import com.jotace.createusercleancode.infra.impl.presenter.user.UpdateUserPresenterImpl;
import com.jotace.createusercleancode.infra.mapper.user.UserMapper;
import com.jotace.createusercleancode.infra.persistence.user.UserEntityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
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


}
