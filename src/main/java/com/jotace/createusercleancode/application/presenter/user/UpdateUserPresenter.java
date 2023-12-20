package com.jotace.createusercleancode.application.presenter.user;

import com.jotace.createusercleancode.core.model.user.UserUpdateResponseModel;

public interface UpdateUserPresenter {

    UserUpdateResponseModel prepareSuccessView(UserUpdateResponseModel response);

    UserUpdateResponseModel prepareFailView(String error);
}
