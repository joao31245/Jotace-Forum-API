package com.jotace.createusercleancode.core.entity.post;

import com.jotace.createusercleancode.core.entity.user.User;

public interface Post {

    String getTitle();
    String getImage();
    String getDescription();
    User getOwner();
    PostCategory getCategory();
}
