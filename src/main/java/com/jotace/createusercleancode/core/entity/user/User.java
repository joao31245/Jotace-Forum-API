package com.jotace.createusercleancode.core.entity.user;

import java.sql.Blob;

public interface User {

    boolean validPassword(String password);

    Long getId();

    void setId(Long id);
    String getPassword();
    String getName();
    String getImage();
    String getEmail();

}
