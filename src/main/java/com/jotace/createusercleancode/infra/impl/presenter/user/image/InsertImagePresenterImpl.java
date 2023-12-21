package com.jotace.createusercleancode.infra.impl.presenter.user.image;

import com.jotace.createusercleancode.application.presenter.user.image.InsertImagePresenter;
import com.jotace.createusercleancode.core.model.user.SetProfileImageResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InsertImagePresenterImpl implements InsertImagePresenter {
    @Override
    public SetProfileImageResponseModel prepareSuccessView(SetProfileImageResponseModel response) {
        return response;
    }

    @Override
    public SetProfileImageResponseModel prepareFailView(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }
}
