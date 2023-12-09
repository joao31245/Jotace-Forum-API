package com.jotace.createusercleancode.main;

import com.jotace.createusercleancode.application.boundary.UserInputBoundary;
import com.jotace.createusercleancode.application.gateway.UserGateway;
import com.jotace.createusercleancode.application.presenter.CreateUserPresenter;
import com.jotace.createusercleancode.application.usecases.UserInteractor;
import com.jotace.createusercleancode.infra.impl.gateway.UserGatewayImpl;
import com.jotace.createusercleancode.infra.impl.presenter.CreateUserPresenterImpl;
import com.jotace.createusercleancode.infra.mapper.UserMapper;
import com.jotace.createusercleancode.infra.persistence.UserEntityRepository;
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
                                        CreateUserPresenter createUserPresenter) {
        return new UserInteractor(registerUserGateway, createUserPresenter);
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
}
