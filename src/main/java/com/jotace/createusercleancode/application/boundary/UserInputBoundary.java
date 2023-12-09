package com.jotace.createusercleancode.application.boundary;

import com.jotace.createusercleancode.application.model.UserRequestModel;
import com.jotace.createusercleancode.application.model.UserResponseModel;

import java.util.List;

public interface UserInputBoundary {
    UserResponseModel create(UserRequestModel userRequestModel);

    List<UserResponseModel> getAllUsers();
}
