package com.jotace.createusercleancode.core.entity;

public class CommonUser implements User{
    private String password;
    private String name;

    public CommonUser(String name, String password) {
        if(this.validPassword(password)) {
            this.password = password;
        }
        this.name = name;
    }
    @Override
    public boolean validPassword(String password) {
        return password.length() > 5;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
