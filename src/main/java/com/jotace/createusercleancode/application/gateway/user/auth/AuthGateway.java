package com.jotace.createusercleancode.application.gateway.user.auth;

import com.jotace.createusercleancode.core.model.auth.AuthRequestModel;
import com.jotace.createusercleancode.core.entity.user.User;

public interface AuthGateway {
    String generateAuthenticationToken(AuthRequestModel requestModel);

    User findUserByEmail(String email);

}
