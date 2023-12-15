package com.jotace.createusercleancode.infra.impl.gateway.post;

import com.jotace.createusercleancode.application.gateway.post.FindUserGateway;
import com.jotace.createusercleancode.core.entity.user.User;
import com.jotace.createusercleancode.infra.mapper.user.UserMapper;
import com.jotace.createusercleancode.infra.persistence.user.UserEntityRepository;

public class FindUserGatewayImpl implements FindUserGateway {
    private final UserEntityRepository userEntityRepository;
    private final UserMapper userMapper;

    public FindUserGatewayImpl(UserEntityRepository userEntityRepository, UserMapper userMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User findUserById(Long id) {
        return userMapper.toAbstract(userEntityRepository.findUserById(id));
    }
}
