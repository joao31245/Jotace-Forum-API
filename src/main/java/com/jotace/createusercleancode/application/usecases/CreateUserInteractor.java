package com.jotace.createusercleancode.application.usecases;

import com.jotace.createusercleancode.application.boundary.UserInputBoundary;
import com.jotace.createusercleancode.application.gateway.RegisterUserGateway;
import com.jotace.createusercleancode.application.model.UserRequestModel;
import com.jotace.createusercleancode.application.model.UserResponseModel;
import com.jotace.createusercleancode.application.presenter.CreateUserPresenter;
import com.jotace.createusercleancode.core.entity.CommonUserFactory;

import java.time.LocalDateTime;
import java.util.List;

public class CreateUserInteractor implements UserInputBoundary {

    private final RegisterUserGateway registerUserGateway;
    private final CreateUserPresenter createUserPresenter;
    public CreateUserInteractor(RegisterUserGateway registerUserGateway, CreateUserPresenter createUserPresenter) {
        this.registerUserGateway = registerUserGateway;
        this.createUserPresenter = createUserPresenter;
    }

    @Override
    public UserResponseModel create(UserRequestModel userRequestModel) {
        var user = new CommonUserFactory().createUser(userRequestModel.name(), userRequestModel.password());

        if(user.getPassword() == null) {
            return createUserPresenter.prepareFailView("User password must have more than 5 characters.");
        }

        registerUserGateway.save(user);

        return createUserPresenter.prepareSuccessView(new UserResponseModel(user.getName(), LocalDateTime.now()));
    }

    @Override
    public List<UserResponseModel> getAllUsers() {
        throw new RuntimeException("CreateUserInteractor does not support this functionality");
    }
}
