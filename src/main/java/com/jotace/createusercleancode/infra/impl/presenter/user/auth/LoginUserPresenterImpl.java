package com.jotace.createusercleancode.infra.impl.presenter.user.auth;

import com.jotace.createusercleancode.core.model.auth.AuthResponseModel;
import com.jotace.createusercleancode.application.presenter.user.auth.LoginUserPresenter;
import com.jotace.createusercleancode.core.exception.UserIsNullException;

public class LoginUserPresenterImpl implements LoginUserPresenter {
    @Override
    public AuthResponseModel prepareSuccessView(AuthResponseModel response) {
        return response;
    }

    @Override
    public AuthResponseModel prepareFailView(String error) {
        throw new UserIsNullException(error);
    }
}
