package com.jotace.createusercleancode.core.entity.post;

import com.jotace.createusercleancode.core.entity.user.User;

public interface Post {

    Long getId();
    void setId(Long id);
    String getTitle();
    String getImage();
    String getDescription();
    User getOwner();
    PostCategory getCategory();
}
