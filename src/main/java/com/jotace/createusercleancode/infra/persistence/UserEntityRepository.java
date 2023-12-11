package com.jotace.createusercleancode.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    @Query("SELECT u FROM users u")
    List<UserEntity> findAllUserEntity();
    @Query("SELECT u FROM users u WHERE u.id = :userId")
    UserEntity findUserById(@Param("userId") Long id);

    boolean existsByEmail(String email);
}
