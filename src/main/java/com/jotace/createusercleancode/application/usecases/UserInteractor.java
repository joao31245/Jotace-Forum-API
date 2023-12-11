package com.jotace.createusercleancode.application.usecases;

import com.jotace.createusercleancode.application.boundary.UserInputBoundary;
import com.jotace.createusercleancode.application.gateway.UserGateway;
import com.jotace.createusercleancode.application.model.UserRequestModel;
import com.jotace.createusercleancode.application.model.UserResponseModel;
import com.jotace.createusercleancode.application.model.UserUpdateRequestModel;
import com.jotace.createusercleancode.application.model.UserUpdateResponseModel;
import com.jotace.createusercleancode.application.presenter.CreateUserPresenter;
import com.jotace.createusercleancode.application.presenter.UpdateUserPresenter;
import com.jotace.createusercleancode.core.entity.CommonUserFactory;

import java.time.LocalDateTime;
import java.util.List;

public class UserInteractor implements UserInputBoundary {
    private final UserGateway userGateway;
    private final CreateUserPresenter createUserPresenter;
    private final UpdateUserPresenter updateUserPresenter;

    public UserInteractor(UserGateway userGateway, CreateUserPresenter createUserPresenter, UpdateUserPresenter updateUserPresenter) {
        this.userGateway = userGateway;
        this.createUserPresenter = createUserPresenter;
        this.updateUserPresenter = updateUserPresenter;
    }

    @Override
    public UserResponseModel create(UserRequestModel userRequestModel) {
        var user = new CommonUserFactory().createUser(userRequestModel.name(), userRequestModel.password(), userRequestModel.email());

        if(user.getPassword() == null) {
            return createUserPresenter.prepareFailView("User password must have more than 5 characters.");
        }

        user = userGateway.save(user);

        return createUserPresenter.prepareSuccessView(new UserResponseModel(user.getId(), user.getName(), LocalDateTime.now(), userRequestModel.email()));
    }

    @Override
    public List<UserResponseModel> getAllUsers() {
        var list = userGateway.getALlUser().stream().map(UserResponseModel::new).toList();

        return list;
    }

    @Override
    public UserUpdateResponseModel update(UserUpdateRequestModel userUpdateRequestModel) {
        var user = userGateway.update(userUpdateRequestModel);
        return updateUserPresenter.prepareSuccessView(new UserUpdateResponseModel(user.getName(), user.getEmail()));
    }

    @Override
    public void delete(Long id) {
        this.userGateway.delete(id);
    }
}
