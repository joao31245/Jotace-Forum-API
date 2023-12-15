package com.jotace.createusercleancode.main.config.auth;

import com.jotace.createusercleancode.core.boundary.user.auth.AuthInputBoundary;
import com.jotace.createusercleancode.application.gateway.user.auth.AuthGateway;
import com.jotace.createusercleancode.application.gateway.user.token.provider.TokenProvider;
import com.jotace.createusercleancode.application.presenter.user.auth.LoginUserPresenter;
import com.jotace.createusercleancode.application.usecases.auth.AuthInteractor;
import com.jotace.createusercleancode.infra.impl.gateway.user.auth.AuthGatewayImpl;
import com.jotace.createusercleancode.infra.impl.presenter.user.auth.LoginUserPresenterImpl;
import com.jotace.createusercleancode.infra.mapper.user.UserMapper;
import com.jotace.createusercleancode.infra.persistence.user.UserEntityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class AuthConfig {
    @Bean
    AuthInputBoundary authInputBoundary(AuthGateway authGateway, LoginUserPresenter loginUserPresenter) {
        return new AuthInteractor(authGateway, loginUserPresenter);
    }
    @Bean
    AuthGateway authGateway(UserEntityRepository  userEntityRepository, TokenProvider tokenProvider,
                            UserMapper userMapper, AuthenticationManager authenticationManager) {
        return new AuthGatewayImpl(userEntityRepository, tokenProvider, userMapper, authenticationManager);
    }
    @Bean
    LoginUserPresenter loginUserPresenter(LoginUserPresenterImpl loginUserPresenter) {
        return loginUserPresenter;
    }
    @Bean
    LoginUserPresenterImpl loginUserPresenterImpl( ) {
        return new LoginUserPresenterImpl();
    }

}
