package com.jotace.createusercleancode.core.entity.post;

import com.jotace.createusercleancode.core.entity.user.User;

import java.sql.Blob;

public interface Post {

    Long getId();
    void setId(Long id);
    String getTitle();
    Blob getImage();
    void setImage(Blob image);
    String getDescription();
    User getOwner();
    PostCategory getCategory();
}
