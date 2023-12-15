package com.jotace.createusercleancode.application.gateway.user.token;

import com.jotace.createusercleancode.core.entity.user.User;

public interface TokenGateway {
    String generateToken(User user);
    String getSubject(String token);
}
