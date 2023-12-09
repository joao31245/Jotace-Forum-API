package com.jotace.createusercleancode.core.entity;

public interface User {

    boolean validPassword(String password);

    String getPassword();
    String getName();
}
