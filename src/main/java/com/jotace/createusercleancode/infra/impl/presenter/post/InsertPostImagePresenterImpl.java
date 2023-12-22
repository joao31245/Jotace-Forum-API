package com.jotace.createusercleancode.infra.impl.presenter.post;

import com.jotace.createusercleancode.application.presenter.post.InsertPostImagePresenter;
import com.jotace.createusercleancode.core.model.post.SetPostImageModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InsertPostImagePresenterImpl implements InsertPostImagePresenter {

    @Override
    public SetPostImageModel prepareSuccessView(SetPostImageModel response) {
        return response;
    }

    @Override
    public SetPostImageModel prepareFailView(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }
}
