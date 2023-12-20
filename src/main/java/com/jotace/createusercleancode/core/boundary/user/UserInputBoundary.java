package com.jotace.createusercleancode.core.boundary.user;

import com.jotace.createusercleancode.core.model.user.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserInputBoundary {
    UserResponseModel create(UserRequestModel userRequestModel);
    List<UserResponseModel> getAllUsers();
    UserUpdateResponseModel update(UserUpdateRequestModel userUpdateRequestModel);
    void delete(Long id);
    SetProfileImageResponseModel setProfileImage(MultipartFile multipartFile);
    UserResponseModel findUserById(Long id);

}
