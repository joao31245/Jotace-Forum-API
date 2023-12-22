package com.jotace.createusercleancode.application.presenter.post;

import com.jotace.createusercleancode.core.model.post.SetPostImageModel;

public interface InsertPostImagePresenter {
    SetPostImageModel prepareSuccessView(SetPostImageModel response);
    SetPostImageModel prepareFailView(String error);
}
