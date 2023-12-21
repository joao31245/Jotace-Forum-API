package com.jotace.createusercleancode.infra.mapper.user;

import com.jotace.createusercleancode.core.entity.post.CommonPostFactory;
import com.jotace.createusercleancode.core.entity.post.Post;
import com.jotace.createusercleancode.core.entity.user.CommonUserFactory;
import com.jotace.createusercleancode.core.entity.user.User;
import com.jotace.createusercleancode.infra.persistence.user.UserEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public UserEntity toEntity(User user) {
        if(user.getImage() != null) {
            return new UserEntity(user.getName(), user.getPassword(), LocalDateTime.now(), user.getEmail(), user.getImage());
        }
        return new UserEntity(user.getName(), user.getPassword(), LocalDateTime.now(), user.getEmail());
    }

    public User toAbstract(UserEntity user) {
        var userAbstract = new CommonUserFactory().createUser(user.getName(),
                user.getPassword(),
                user.getEmail());

        userAbstract.setId(user.getId());

        var posts = user.getPosts();


        List<Post> postsAbstracts = new ArrayList<>();

        if(posts != null) {
            posts.forEach(postEntity -> {
                postsAbstracts.add(new CommonPostFactory().createWithId(postEntity.getId(),postEntity.getTitle(),
                        postEntity.getDescription(), userAbstract, postEntity.getPostCategory()));
            });
        }

        userAbstract.setPosts(postsAbstracts);

        if(user.getImage() != null) {
            userAbstract.setImage(user.getImage());
        }

        return userAbstract;
    }
}
