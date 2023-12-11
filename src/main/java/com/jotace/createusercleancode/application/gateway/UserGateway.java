package com.jotace.createusercleancode.application.gateway;

import com.jotace.createusercleancode.application.model.UserUpdateRequestModel;
import com.jotace.createusercleancode.core.entity.user.User;

import java.util.List;

public interface UserGateway {
    boolean existsByName(String name);
    User save(User user);
    List<User> getALlUser();
    User update(UserUpdateRequestModel userUpdateRequestModel);

    void delete(Long id);

    User findUserById(Long id);
}
