package com.jotace.createusercleancode.application.presenter;

import com.jotace.createusercleancode.application.model.UserResponseModel;

public interface CreateUserPresenter {
    UserResponseModel prepareSuccessView(UserResponseModel response);

    UserResponseModel prepareFailView(String error);
}
