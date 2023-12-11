package com.jotace.createusercleancode.application.boundary;

import com.jotace.createusercleancode.application.model.UserRequestModel;
import com.jotace.createusercleancode.application.model.UserResponseModel;
import com.jotace.createusercleancode.application.model.UserUpdateRequestModel;
import com.jotace.createusercleancode.application.model.UserUpdateResponseModel;

import java.util.List;

public interface UserInputBoundary {
    UserResponseModel create(UserRequestModel userRequestModel);
    List<UserResponseModel> getAllUsers();
    UserUpdateResponseModel update(UserUpdateRequestModel userUpdateRequestModel);
    void delete(Long id);
    UserResponseModel findUserById(Long id);

}
