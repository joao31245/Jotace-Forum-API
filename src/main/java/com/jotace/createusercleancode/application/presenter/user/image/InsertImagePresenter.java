package com.jotace.createusercleancode.application.presenter.user.image;

import com.jotace.createusercleancode.core.model.user.SetProfileImageResponseModel;

public interface InsertImagePresenter {

    SetProfileImageResponseModel prepareSuccessView(SetProfileImageResponseModel response);

    SetProfileImageResponseModel prepareFailView(String error);
}
