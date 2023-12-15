package com.jotace.createusercleancode.infra.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;


public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    @Query("SELECT u FROM users u")
    List<UserEntity> findAllUserEntity();
    @Query("SELECT u FROM users u WHERE u.id = :userId")
    UserEntity findUserById(@Param("userId") Long id);

    boolean existsByEmail(String email);

    @Query("SELECT u FROM users u WHERE u.email = :email")
    UserDetails findByLogin(@Param("email")String email);
}
