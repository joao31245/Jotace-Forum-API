package com.jotace.createusercleancode.core.entity.post;

import com.jotace.createusercleancode.core.entity.user.User;

import java.sql.Blob;

public class CommonPost implements Post{
    private Long id;
    private String title;
    private Blob image;
    private String description;
    private User owner;
    private PostCategory category;

    public CommonPost(String title, String description, User user, PostCategory category) {
        this.title = title;
        this.description = description;
        this.owner = user;
        this.category = category;
    }

    public CommonPost(Long id,String title, String description, User user, PostCategory category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.owner = user;
        this.category = category;
    }



    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return this.title;
    }
    @Override
    public Blob getImage() {
        return this.image;
    }
    @Override
    public void setImage(Blob image) {
        this.image = image;
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
