package com.jotace.createusercleancode.core.entity.post;

import com.jotace.createusercleancode.core.entity.user.User;

public class CommonPostFactory implements PostFactory{
    @Override
    public Post create(String title, String image, String description, User user, PostCategory category) {
        return new CommonPost(title, image, description, user, category);
    }

    @Override
    public Post createWithId(Long id, String title, String image, String description, User userAbstract, PostCategory postCategory) {
        return new CommonPost(id,title, image, description, userAbstract, postCategory);
    }
}
