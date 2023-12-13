package com.jotace.createusercleancode.application.gateway.post;

import com.jotace.createusercleancode.core.entity.user.User;

public interface FindUserGateway {
    User findUserById(Long id);
}
