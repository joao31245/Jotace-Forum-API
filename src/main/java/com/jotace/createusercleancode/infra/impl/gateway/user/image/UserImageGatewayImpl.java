package com.jotace.createusercleancode.infra.impl.gateway.user.image;

import com.jotace.createusercleancode.application.gateway.user.UserImageGateway;
import com.jotace.createusercleancode.core.entity.user.User;
import com.jotace.createusercleancode.infra.mapper.user.UserMapper;
import com.jotace.createusercleancode.infra.persistence.user.UserEntityRepository;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;

public class UserImageGatewayImpl implements UserImageGateway {

    private final UserEntityRepository userEntityRepository;

    public UserImageGatewayImpl(UserEntityRepository userEntityRepository, UserMapper userMapper) {
        this.userEntityRepository = userEntityRepository;
    }


    @Override
    public Blob setImage(Long id, SerialBlob image) {
        var userEntity = userEntityRepository.findUserById(id);

        userEntity.setImage(image);

        userEntityRepository.save(userEntity);

        return userEntity.getImage();
    }
}
