package com.jotace.createusercleancode.infra.impl.presenter;

import com.jotace.createusercleancode.application.model.UserResponseModel;
import com.jotace.createusercleancode.application.presenter.CreateUserPresenter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
