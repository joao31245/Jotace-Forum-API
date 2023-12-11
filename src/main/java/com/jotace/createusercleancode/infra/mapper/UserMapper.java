package com.jotace.createusercleancode.infra.mapper;

import com.jotace.createusercleancode.core.entity.user.CommonUserFactory;
import com.jotace.createusercleancode.core.entity.user.User;
import com.jotace.createusercleancode.infra.persistence.UserEntity;

import java.time.LocalDateTime;

public class UserMapper {

    public UserEntity toEntity(User user) {
        return new UserEntity(user.getName(), user.getPassword(), LocalDateTime.now(), user.getEmail());
    }

    public User toAbstract(UserEntity user) {
        var userAbstract = new CommonUserFactory().createUser(user.getName(),
                user.getPassword(),
                user.getEmail());
        userAbstract.setId(user.getId());
        return userAbstract;
    }
}
