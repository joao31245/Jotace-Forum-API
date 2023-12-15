package com.jotace.createusercleancode.infra.impl.presenter.user.auth;

import com.jotace.createusercleancode.application.model.auth.AuthResponseModel;
import com.jotace.createusercleancode.application.presenter.user.auth.LoginUserPresenter;
import com.jotace.createusercleancode.core.exception.UserDoesNotExistException;

public class LoginUserPresenterImpl implements LoginUserPresenter {
    @Override
    public AuthResponseModel prepareSuccessView(AuthResponseModel response) {
        return response;
    }

    @Override
    public AuthResponseModel prepareFailView(String error) {
        throw new UserDoesNotExistException();
    }
}
