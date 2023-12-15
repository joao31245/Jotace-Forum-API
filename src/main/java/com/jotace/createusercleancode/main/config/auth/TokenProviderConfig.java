package com.jotace.createusercleancode.main.config.auth;

import com.jotace.createusercleancode.application.gateway.user.token.provider.TokenProvider;
import com.jotace.createusercleancode.infra.impl.gateway.user.token.provider.Auth0TokenProvider;
import com.jotace.createusercleancode.infra.mapper.user.UserMapper;
import com.jotace.createusercleancode.infra.persistence.user.UserEntityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenProviderConfig {
        private final UserEntityRepository userEntityRepository;
        private final UserMapper userMapper;

        public TokenProviderConfig(UserEntityRepository userEntityRepository, UserMapper userMapper) {
            this.userEntityRepository = userEntityRepository;
            this.userMapper = userMapper;
        }

        @Bean
        public TokenProvider auth0TokenProvider() {
            return new Auth0TokenProvider(userEntityRepository, userMapper);
        }
}

