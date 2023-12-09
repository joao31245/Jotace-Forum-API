package com.jotace.createusercleancode.application.usecases;

import com.jotace.createusercleancode.application.boundary.UserInputBoundary;
import com.jotace.createusercleancode.application.exception.FailException;
import com.jotace.createusercleancode.application.gateway.UserGateway;
import com.jotace.createusercleancode.application.model.UserRequestModel;
import com.jotace.createusercleancode.application.model.UserResponseModel;
import com.jotace.createusercleancode.application.presenter.CreateUserPresenter;
import com.jotace.createusercleancode.core.entity.CommonUserFactory;

import java.time.LocalDateTime;
import java.util.List;

public class UserInteractor implements UserInputBoundary {

    private final UserGateway userGateway;
    private final CreateUserPresenter createUserPresenter;
    public UserInteractor(UserGateway userGateway, CreateUserPresenter createUserPresenter) {
        this.userGateway = userGateway;
        this.createUserPresenter = createUserPresenter;
    }

    @Override
    public UserResponseModel create(UserRequestModel userRequestModel) {
        var user = new CommonUserFactory().createUser(userRequestModel.name(), userRequestModel.password());

        if(user.getPassword() == null) {
            return createUserPresenter.prepareFailView("User password must have more than 5 characters.");
        }

        userGateway.save(user);

        return createUserPresenter.prepareSuccessView(new UserResponseModel(user.getName(), LocalDateTime.now()));
    }

    @Override
    public List<UserResponseModel> getAllUsers() {
        var list = userGateway.getALlUser().stream().map(UserResponseModel::new).toList();

        if(list.isEmpty()) {
            throw new FailException("No user found");
        }

        return list;
    }

}
