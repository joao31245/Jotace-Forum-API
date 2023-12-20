package com.jotace.createusercleancode.infra.impl.gateway.user.crud;

import com.jotace.createusercleancode.application.gateway.user.UserGateway;
import com.jotace.createusercleancode.core.model.user.UserUpdateRequestModel;
import com.jotace.createusercleancode.core.entity.user.User;
import com.jotace.createusercleancode.core.exception.EmailAlreadyExistsException;
import com.jotace.createusercleancode.infra.mapper.user.UserMapper;
import com.jotace.createusercleancode.infra.persistence.user.UserEntityRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User save(User user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException();
        }

        var userEntity = userMapper.toEntity(user);

        userEntity.setPassword(encryptPassword(user.getPassword()));

        userRepository.save(userEntity);

        return userMapper.toAbstract(userEntity);

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

    @Override
    public User update(UserUpdateRequestModel userUpdateRequestModel) {
        var user = userRepository.findUserById(userUpdateRequestModel.userId());

        if(userUpdateRequestModel.name() != null) {
            user.setName(userUpdateRequestModel.name());
        }
        if(userUpdateRequestModel.email() != null) {
            user.setEmail(userUpdateRequestModel.email());
        }

        userRepository.save(user);

        return userMapper.toAbstract(user);
    }
    @Override
    public void delete(Long id) {
        var user = userRepository.findUserById(id);
        userRepository.delete(user);
    }
    @Override
    public User findUserById(Long id) {
        return userMapper.toAbstract(userRepository.findUserById(id));
    }
    @Override
    public String encryptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
