package com.jotace.createusercleancode.core.entity.user;

public class CommonUserFactory implements UserFactory {
    @Override
    public User createUser(String name, String password, String email) {
        return new CommonUser(name, password, email);
    }
}
