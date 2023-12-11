package com.jotace.createusercleancode.core.entity.user;

public interface UserFactory {
    User createUser(String name, String password, String Email);
}
