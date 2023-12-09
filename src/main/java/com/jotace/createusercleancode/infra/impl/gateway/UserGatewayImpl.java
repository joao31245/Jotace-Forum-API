package com.jotace.createusercleancode.infra.impl.gateway;

import com.jotace.createusercleancode.application.gateway.UserGateway;
import com.jotace.createusercleancode.core.entity.User;
import com.jotace.createusercleancode.infra.mapper.UserMapper;
import com.jotace.createusercleancode.infra.persistence.UserEntityRepository;

import java.util.ArrayList;
import java.util.List;

public class UserGatewayImpl implements UserGateway {

    private final UserEntityRepository userRepository;
    private final UserMapper userMapper;

    public UserGatewayImpl(UserEntityRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public boolean existsByName(String name) {
        return userRepository.existsByName(name);
    }

    @Override
    public void save(User user) {
        if(existsByName(user.getName())) {
            throw new RuntimeException("Already exists an user with this name");
        }

       var userEntity = userMapper.toEntity(user);
       userRepository.save(userEntity);
    }

    @Override
    public List<User> getALlUser() {
        var list = userRepository.findAllUserEntity();

        List<User> abstractList = new ArrayList<>();

        list.forEach(user -> {
            abstractList.add(userMapper.toAbstract(user));
        });

        return abstractList;
    }
}
