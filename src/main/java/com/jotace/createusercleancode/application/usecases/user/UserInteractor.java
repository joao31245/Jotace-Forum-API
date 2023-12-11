package com.jotace.createusercleancode.application.usecases.user;

import com.jotace.createusercleancode.application.boundary.user.UserInputBoundary;
import com.jotace.createusercleancode.application.gateway.user.UserGateway;
import com.jotace.createusercleancode.application.model.user.UserRequestModel;
import com.jotace.createusercleancode.application.model.user.UserResponseModel;
import com.jotace.createusercleancode.application.model.user.UserUpdateRequestModel;
import com.jotace.createusercleancode.application.model.user.UserUpdateResponseModel;
import com.jotace.createusercleancode.application.presenter.user.CreateUserPresenter;
import com.jotace.createusercleancode.application.presenter.user.UpdateUserPresenter;
import com.jotace.createusercleancode.core.entity.user.CommonUserFactory;

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

    @Override
    public UserResponseModel findUserById(Long id) {
        var user = userGateway.findUserById(id);
        return new UserResponseModel(user);
    }
}
