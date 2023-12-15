package com.jotace.createusercleancode.infra.impl.gateway.user.auth;

import com.jotace.createusercleancode.application.gateway.user.auth.AuthGateway;
import com.jotace.createusercleancode.application.gateway.user.token.provider.TokenProvider;
import com.jotace.createusercleancode.application.model.auth.AuthRequestModel;
import com.jotace.createusercleancode.core.entity.user.User;
import com.jotace.createusercleancode.infra.mapper.user.UserMapper;
import com.jotace.createusercleancode.infra.persistence.user.UserEntity;
import com.jotace.createusercleancode.infra.persistence.user.UserEntityRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthGatewayImpl implements AuthGateway {

    private final UserEntityRepository userEntityRepository;
    private final TokenProvider tokenProvider;
    private final UserMapper userMapper;

    private final AuthenticationManager authenticationManager;

    public AuthGatewayImpl(UserEntityRepository userEntityRepository, TokenProvider tokenProvider, UserMapper userMapper, AuthenticationManager authenticationManager) {
        this.userEntityRepository = userEntityRepository;
        this.tokenProvider = tokenProvider;
        this.userMapper = userMapper;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public String generateAuthenticationToken(AuthRequestModel requestModel) {
        var credentials = new UsernamePasswordAuthenticationToken(requestModel.email(), requestModel.password());

        var authentication = authenticationManager.authenticate(credentials);

        var userDetails = (UserEntity) authentication.getPrincipal();

        var user = userMapper.toAbstract(userDetails);

        var token = tokenProvider.generateToken(user);

        return token;
    }

    @Override
    public User findUserByEmail(String email) {
        var user = (UserEntity) userEntityRepository.findByLogin(email);
        return userMapper.toAbstract(user);
    }

}
