package com.jotace.createusercleancode.core.boundary.user;

import com.jotace.createusercleancode.application.model.user.UserRequestModel;
import com.jotace.createusercleancode.application.model.user.UserResponseModel;
import com.jotace.createusercleancode.application.model.user.UserUpdateRequestModel;
import com.jotace.createusercleancode.application.model.user.UserUpdateResponseModel;

import java.util.List;

public interface UserInputBoundary {
    UserResponseModel create(UserRequestModel userRequestModel);
    List<UserResponseModel> getAllUsers();
    UserUpdateResponseModel update(UserUpdateRequestModel userUpdateRequestModel);
    void delete(Long id);
    UserResponseModel findUserById(Long id);

}
