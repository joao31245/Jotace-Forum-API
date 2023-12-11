package com.jotace.createusercleancode.gateway.impl;
import com.jotace.createusercleancode.application.model.UserUpdateRequestModel;
import com.jotace.createusercleancode.core.entity.user.CommonUserFactory;
import com.jotace.createusercleancode.core.entity.user.User;
import com.jotace.createusercleancode.infra.impl.gateway.UserGatewayImpl;
import com.jotace.createusercleancode.infra.mapper.UserMapper;
import com.jotace.createusercleancode.infra.persistence.UserEntity;
import com.jotace.createusercleancode.infra.persistence.UserEntityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class UserGatewayImplTest {

        private UserGatewayImpl userGateway;
        private UserEntityRepository userRepository;
        private UserMapper userMapper;

        @BeforeEach
        void setUp() {
            userRepository = mock(UserEntityRepository.class);
            userMapper = mock(UserMapper.class);

            userGateway = new UserGatewayImpl(userRepository, userMapper);
        }

        @Test
        void testSaveUser_WithNonExistingName_ShouldSaveSuccessfully() {
            when(userRepository.existsByName(any())).thenReturn(false);
            when(userMapper.toEntity(any())).thenReturn(new UserEntity("example", "123", LocalDateTime.now(), "jotace@123"));
            when(userRepository.save(any())).thenReturn(new UserEntity("example", "123", LocalDateTime.now(), "jotace@123"));
            when(userMapper.toAbstract(any())).thenReturn(new CommonUserFactory().createUser("example", "123", "jotace@123"));

            User savedUser = userGateway.save(new CommonUserFactory().createUser("example", "123", "jotace@123"));

            assertNotNull(savedUser);
        }

        @Test
        void testSaveUser_WithExistingName_ShouldThrowException() {
            when(userRepository.existsByName(any())).thenReturn(true);

            assertThrows(RuntimeException.class, () -> userGateway.save(new CommonUserFactory().createUser("jotace", "123","jotace@123")));
        }

        @Test
        void testGetAllUsers_ShouldReturnListOfUsers() {
            when(userRepository.findAllUserEntity()).thenReturn(new ArrayList<UserEntity>());
            when(userMapper.toAbstract(any())).thenReturn(new CommonUserFactory().createUser("example", "123", "example@gmail.com"));

            List<User> userList = userGateway.getALlUser();

            assertFalse(userList.isEmpty());
        }

        @Test
        void testUpdateUser_ShouldUpdateSuccessfully() {
            when(userRepository.findUserById(any())).thenReturn(new UserEntity(1L,"example", "123", "example@gmail.com", "imageexample", LocalDateTime.now()));
            when(userMapper.toAbstract(any())).thenReturn(new CommonUserFactory().createUser("example", "123", "example@gmail.com"));

            User updatedUser = userGateway.update(new UserUpdateRequestModel(1L,"jotace", "123"));

            assertNotNull(updatedUser);
        }

        @Test
        void testDeleteUser_WithExistingUser_ShouldDeleteSuccessfully() {
            when(userRepository.findUserById(any())).thenReturn(new UserEntity(1L,"example", "123", "example@gmail.com", "imageexample", LocalDateTime.now()));

            userGateway.delete(1L);

            verify(userRepository).delete(any());
        }

        @Test
        void testDeleteUser_WithNonExistingUser_ShouldNotThrowException() {
            when(userRepository.findUserById(any())).thenReturn(null);

            assertDoesNotThrow(() -> userGateway.delete(1L));
        }
    }

