package com.jotace.createusercleancode.application.presenter.user.auth;

import com.jotace.createusercleancode.core.model.auth.AuthResponseModel;

public interface LoginUserPresenter {
    AuthResponseModel prepareSuccessView(AuthResponseModel response);

    AuthResponseModel prepareFailView(String error);
}
