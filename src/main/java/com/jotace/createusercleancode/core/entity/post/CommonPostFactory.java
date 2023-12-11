package com.jotace.createusercleancode.core.entity.post;

import com.jotace.createusercleancode.core.entity.user.User;

public class CommonPostFactory implements PostFactory{
    @Override
    public Post create(String title, String image, String description, User user, PostCategory category) {
        return new CommonPost(title, image, description, user, category);
    }
}
