package com.jotace.createusercleancode.infra.impl.presenter.user;

import com.jotace.createusercleancode.core.model.user.UserResponseModel;
import com.jotace.createusercleancode.application.presenter.user.CreateUserPresenter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CreateUserPresenterImpl implements CreateUserPresenter {
    @Override
    public UserResponseModel prepareSuccessView(UserResponseModel response) {
        return response;
    }

    @Override
    public UserResponseModel prepareFailView(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }
}
