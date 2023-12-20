package com.jotace.createusercleancode.application.presenter.post;

import com.jotace.createusercleancode.core.model.post.PostResponseModel;

public interface CreatePostPresenter {
    PostResponseModel prepareSuccessView(PostResponseModel response);

    PostResponseModel prepareFailView(String error);
}
