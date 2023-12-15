package com.jotace.createusercleancode.application.presenter.user.auth;

import com.jotace.createusercleancode.application.model.auth.AuthResponseModel;
import com.jotace.createusercleancode.application.model.user.UserResponseModel;

public interface LoginUserPresenter {
    AuthResponseModel prepareSuccessView(AuthResponseModel response);

    AuthResponseModel prepareFailView(String error);
}
