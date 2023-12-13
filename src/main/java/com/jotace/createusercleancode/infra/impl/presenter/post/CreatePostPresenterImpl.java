package com.jotace.createusercleancode.infra.impl.presenter.post;

import com.jotace.createusercleancode.application.model.post.PostResponseModel;
import com.jotace.createusercleancode.application.presenter.post.CreatePostPresenter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CreatePostPresenterImpl implements CreatePostPresenter {
    @Override
    public PostResponseModel prepareSuccessView(PostResponseModel response) {
        return response;
    }

    @Override
    public PostResponseModel prepareFailView(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }
}
