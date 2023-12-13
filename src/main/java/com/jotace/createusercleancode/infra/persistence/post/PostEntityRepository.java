package com.jotace.createusercleancode.infra.persistence.post;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PostEntityRepository extends JpaRepository<PostEntity,Long> {

    PostEntity findPostById(Long id);
}
