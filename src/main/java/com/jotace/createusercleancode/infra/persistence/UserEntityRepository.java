package com.jotace.createusercleancode.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByName(String name);

    @Query("SELECT u FROM users u")
    List<UserEntity> findAllUserEntity();
}
