package com.jotace.createusercleancode.core.boundary.user;

import com.jotace.createusercleancode.core.model.user.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;
import java.util.List;

public interface UserInputBoundary {
    UserResponseModel create(UserRequestModel userRequestModel) throws SQLException;
    List<UserResponseModel> getAllUsers() throws SQLException;
    UserUpdateResponseModel update(UserUpdateRequestModel userUpdateRequestModel);
    void delete(Long id);
    UserResponseModel findUserById(Long id) throws SQLException;

}
