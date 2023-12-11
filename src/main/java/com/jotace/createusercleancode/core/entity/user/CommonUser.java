package com.jotace.createusercleancode.core.entity.user;

import com.jotace.createusercleancode.core.entity.post.Post;

import java.util.List;

public class CommonUser implements User{

    private Long id;
    private String name;
    private String password;
    private String email;
    private String image;
    private List<Post> posts;

    public CommonUser( String name, String password, String email) {
        if(this.validPassword(password)) {
            this.password = password;
        }
        this.name = name;
        this.email = email;
    }
    @Override
    public boolean validPassword(String password) {
        return password.length() > 5;
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
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getImage() {
        return this.image;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public List<Post> getPosts() {
        return this.posts;
    }

}
