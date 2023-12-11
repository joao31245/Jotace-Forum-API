package com.jotace.createusercleancode.core.entity.user;

import com.jotace.createusercleancode.core.entity.post.Post;

import java.util.List;

public interface User {
    boolean validPassword(String password);
    Long getId();
    void setId(Long id);
    String getPassword();
    String getName();
    String getImage();
    String getEmail();
    List<Post> getPosts();

}
