package com.jotace.createusercleancode.application.presenter.user;

import com.jotace.createusercleancode.core.model.user.UserResponseModel;

public interface CreateUserPresenter {
    UserResponseModel prepareSuccessView(UserResponseModel response);

    UserResponseModel prepareFailView(String error);
}
