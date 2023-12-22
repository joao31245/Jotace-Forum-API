package com.jotace.createusercleancode.core.entity.post;

import com.jotace.createusercleancode.core.entity.user.User;

public interface PostFactory {
    Post create(String title, String description, User user, PostCategory category);

    Post createWithId(Long id, String image, String description, User userAbstract, PostCategory postCategory);
}
