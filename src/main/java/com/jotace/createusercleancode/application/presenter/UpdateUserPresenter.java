package com.jotace.createusercleancode.application.presenter;

import com.jotace.createusercleancode.application.model.UserResponseModel;
import com.jotace.createusercleancode.application.model.UserUpdateResponseModel;

public interface UpdateUserPresenter {

    UserUpdateResponseModel prepareSuccessView(UserUpdateResponseModel response);

    UserUpdateResponseModel prepareFailView(String error);
}
