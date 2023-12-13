package com.jotace.createusercleancode.infra.persistence;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jotace.createusercleancode.infra.persistence.post.PostEntity;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "users")
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    private String email;

    private String image;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<PostEntity> posts;

    private LocalDateTime creationTime;

    public UserEntity(String name, String password, LocalDateTime now, String email) {
        this.name = name;
        this.password = password;
        this.creationTime = now;
        this.email = email;
    }

    public UserEntity(long l, String example, String number, String mail, String imageexample, LocalDateTime now) {
        this.id =l;
        this.name = name;
        this.password = password;
        this.creationTime = now;
        this.email = email;
    }
}
