package com.jotace.createusercleancode.application.presenter.user;

import com.jotace.createusercleancode.application.model.user.UserResponseModel;

public interface CreateUserPresenter {
    UserResponseModel prepareSuccessView(UserResponseModel response);

    UserResponseModel prepareFailView(String error);
}
