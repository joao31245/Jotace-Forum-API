package com.jotace.createusercleancode.infra.mapper;

import com.jotace.createusercleancode.core.entity.CommonUserFactory;
import com.jotace.createusercleancode.core.entity.User;
import com.jotace.createusercleancode.infra.persistence.UserEntity;

import java.time.LocalDateTime;

public class UserMapper {

    public UserEntity toEntity(User user) {
        return new UserEntity(user.getName(), user.getPassword(), LocalDateTime.now());
    }

    public User toAbstract(UserEntity user) {
        return new CommonUserFactory().createUser(user.getName(), user.getPassword());
    }
}
