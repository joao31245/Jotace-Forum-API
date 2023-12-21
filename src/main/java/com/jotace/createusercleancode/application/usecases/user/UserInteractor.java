package com.jotace.createusercleancode.application.usecases.user;

import com.jotace.createusercleancode.core.boundary.user.UserInputBoundary;
import com.jotace.createusercleancode.application.gateway.user.UserGateway;
import com.jotace.createusercleancode.application.presenter.user.CreateUserPresenter;
import com.jotace.createusercleancode.application.presenter.user.UpdateUserPresenter;
import com.jotace.createusercleancode.core.entity.user.CommonUserFactory;
import com.jotace.createusercleancode.core.entity.user.User;
import com.jotace.createusercleancode.core.exception.InsertImageException;
import com.jotace.createusercleancode.core.model.user.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public UserResponseModel create(UserRequestModel userRequestModel) throws SQLException {
        var user = new CommonUserFactory().createUser(userRequestModel.name(), userRequestModel.password(), userRequestModel.email());

        if(user.getPassword() == null) {
            return createUserPresenter.prepareFailView("User password must have more than 5 characters.");
        }

        user = userGateway.save(user);

        return createUserPresenter.prepareSuccessView(new UserResponseModel(user));
    }

    @Override
    public List<UserResponseModel> getAllUsers() throws SQLException {
        List<UserResponseModel> list = new ArrayList<>();

        for (User user : userGateway.getALlUser()) {
            UserResponseModel userResponseModel = new UserResponseModel(user);
            list.add(userResponseModel);
        }

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
    public UserResponseModel findUserById(Long id) throws SQLException {
        var user = userGateway.findUserById(id);
        return createUserPresenter.prepareSuccessView(new UserResponseModel(user));
    }
}
