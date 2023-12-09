package com.jotace.createusercleancode.application.gateway;

import com.jotace.createusercleancode.core.entity.User;

import java.util.List;

public interface UserGateway {
    boolean existsByName(String name);
    void save(User user);
    List<User> getALlUser();

}
