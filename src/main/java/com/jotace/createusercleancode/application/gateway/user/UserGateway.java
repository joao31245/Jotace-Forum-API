package com.jotace.createusercleancode.application.gateway.user;

import com.jotace.createusercleancode.core.model.user.UserUpdateRequestModel;
import com.jotace.createusercleancode.core.entity.user.User;

import java.sql.Blob;
import java.util.List;

public interface UserGateway {
    boolean existsByEmail(String email);
    User save(User user);
    List<User> getALlUser();
    User update(UserUpdateRequestModel userUpdateRequestModel);
    void delete(Long id);
    User findUserById(Long id);
    String encryptPassword(String password);
    Blob insertImage(Blob image);
}
