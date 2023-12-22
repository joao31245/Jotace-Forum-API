package com.jotace.createusercleancode.core.entity.post;

import com.jotace.createusercleancode.core.entity.user.User;

public class CommonPostFactory implements PostFactory{
    @Override
    public Post create(String title, String description, User user, PostCategory category) {
        return new CommonPost(title, description, user, category);
    }

    @Override
    public Post createWithId(Long id, String title,  String description, User userAbstract, PostCategory postCategory) {
        return new CommonPost(id,title, description, userAbstract, postCategory);
    }
}
