package com.jotace.createusercleancode.infra.impl.gateway.user.token.provider;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.jotace.createusercleancode.application.gateway.user.token.provider.TokenProvider;
import com.jotace.createusercleancode.core.entity.user.User;
import com.jotace.createusercleancode.core.exception.CreateJWTTokenException;
import com.jotace.createusercleancode.core.exception.VerificationJWTToken;
import com.jotace.createusercleancode.infra.mapper.user.UserMapper;
import com.jotace.createusercleancode.infra.persistence.user.UserEntity;
import com.jotace.createusercleancode.infra.persistence.user.UserEntityRepository;
import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Auth0TokenProvider implements TokenProvider {
    @Value("${api.security.token.secret}")
    private String secretKey;
    private final UserEntityRepository userEntityRepository;
    private final UserMapper userMapper;

    public Auth0TokenProvider(UserEntityRepository userEntityRepository, UserMapper userMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userMapper = userMapper;
    }

    @Override
    public String generateToken(User user) {
        try {
            var algorithm = Algorithm.HMAC256(secretKey);
            return JWT.create()
                    .withIssuer("Jotace Forum Api")
                    .withSubject(user.getEmail())
                    .withExpiresAt(expirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new CreateJWTTokenException("Fail while create token");
        }
    }

    @Override
    public String getSubject(String token) {
        try {
            var algorithm = Algorithm.HMAC256(secretKey);
            return JWT.require(algorithm)
                    .withIssuer("Jotace Forum Api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new VerificationJWTToken("Fail while verify post");
        }
    }

    @Override
    public Instant expirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    @Override
    public User findUserByLogin(String email) {
        var userEntity = (UserEntity) userEntityRepository.findByLogin(email);

        var userAbstract = userMapper.toAbstract(userEntity);
        return userAbstract;
    }
}
