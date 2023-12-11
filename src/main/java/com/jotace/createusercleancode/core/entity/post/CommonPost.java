package com.jotace.createusercleancode.core.entity.post;

import com.jotace.createusercleancode.core.entity.user.User;

public class CommonPost implements Post{
    private Long id;
    private String title;
    private String image;
    private String description;
    private User owner;
    private PostCategory category;

    public CommonPost(String title, String image, String description, User user, PostCategory category) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.owner = user;
        this.category = category;
    }

    @Override
    public String getTitle() {
        return this.title;
    }
    @Override
    public String getImage() {
        return this.image;
    }
    @Override
    public String getDescription() {
        return this.description;
    }
    @Override
    public User getOwner() {
        return this.owner;
    }
    @Override
    public PostCategory getCategory() {
        return this.category;
    }
}