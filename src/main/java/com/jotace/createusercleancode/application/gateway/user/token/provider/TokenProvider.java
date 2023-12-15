package com.jotace.createusercleancode.application.gateway.user.token.provider;

import com.jotace.createusercleancode.core.entity.user.User;

import java.time.Instant;

public interface TokenProvider {
        String generateToken(User user);
        String getSubject(String token);
        Instant expirationDate();
        User findUserByLogin(String email);
    }

