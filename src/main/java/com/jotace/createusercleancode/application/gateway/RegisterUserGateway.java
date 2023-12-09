package com.jotace.createusercleancode.application.gateway;

import com.jotace.createusercleancode.application.model.UserRequestModel;
import com.jotace.createusercleancode.application.model.UserResponseModel;
import com.jotace.createusercleancode.core.entity.User;

public interface RegisterUserGateway {
    boolean existsByName(String name);
    void save(User user);
}
