package com.jotace.createusercleancode.infra.impl.presenter;

import com.jotace.createusercleancode.application.model.user.UserUpdateResponseModel;
import com.jotace.createusercleancode.application.presenter.user.UpdateUserPresenter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UpdateUserPresenterImpl implements UpdateUserPresenter {

    @Override
    public UserUpdateResponseModel prepareSuccessView(UserUpdateResponseModel response) {
        return response;
    }

    @Override
    public UserUpdateResponseModel prepareFailView(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }
}
