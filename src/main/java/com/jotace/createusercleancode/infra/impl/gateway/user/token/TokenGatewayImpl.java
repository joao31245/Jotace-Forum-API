package com.jotace.createusercleancode.infra.impl.gateway.user.token;

import com.jotace.createusercleancode.application.gateway.user.token.TokenGateway;
import com.jotace.createusercleancode.core.entity.user.User;
import com.jotace.createusercleancode.infra.impl.gateway.user.token.provider.Auth0TokenProvider;
import org.springframework.stereotype.Service;

@Service
public class TokenGatewayImpl implements TokenGateway {
    private final Auth0TokenProvider auth0TokenProvider;
    public TokenGatewayImpl(Auth0TokenProvider auth0TokenProvider) {
        this.auth0TokenProvider = auth0TokenProvider;
    }
    @Override
    public String generateToken(User user) {
        return auth0TokenProvider.generateToken(user);
    }

    @Override
    public String getSubject(String token) {
        return auth0TokenProvider.getSubject(token);
    }

}
