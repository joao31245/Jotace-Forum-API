package com.jotace.createusercleancode.infra.persistence.post;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jotace.createusercleancode.core.entity.post.Post;
import com.jotace.createusercleancode.core.entity.post.PostCategory;
import com.jotace.createusercleancode.infra.persistence.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "posts")
@Table(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String image;

    private String description;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonBackReference
    private UserEntity owner;

    @Enumerated(EnumType.STRING)
    private PostCategory postCategory;

    public PostEntity(Post post) {
        this.title = post.getTitle();
        this.image = post.getImage();
        this.description = post.getDescription();
        this.postCategory = post.getCategory();

        // User
        this.owner = new UserEntity();

        this.owner.setId(post.getOwner().getId());
        this.owner.setName(post.getOwner().getName());
        this.owner.setPassword(post.getOwner().getPassword());
        this.owner.setEmail(post.getOwner().getEmail());
    }
}
