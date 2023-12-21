package com.jotace.createusercleancode.application.usecases.user;

import com.jotace.createusercleancode.application.gateway.user.UserImageGateway;
import com.jotace.createusercleancode.application.presenter.user.image.InsertImagePresenter;
import com.jotace.createusercleancode.core.boundary.user.UserImageBoundary;
import com.jotace.createusercleancode.core.exception.InsertImageException;
import com.jotace.createusercleancode.core.exception.UserIsNullException;
import com.jotace.createusercleancode.core.model.user.SetProfileImageResponseModel;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.SQLException;

public class UserImageInteractor implements UserImageBoundary {
    private final UserImageGateway userImageGateway;

    private final InsertImagePresenter insertImagePresenter;

    public UserImageInteractor(UserImageGateway userImageGateway, InsertImagePresenter insertImagePresenter) {
        this.userImageGateway = userImageGateway;
        this.insertImagePresenter = insertImagePresenter;
    }

    @Override
    public SetProfileImageResponseModel setProfileImage(MultipartFile multipartFile, Long id) {
        try {
            var fileBytes = multipartFile.getBytes();
            var image = new javax.sql.rowset.serial.SerialBlob(fileBytes);
            var imageBytes = image.getBytes(1, (int) image.length());

            return insertImagePresenter.prepareSuccessView(new SetProfileImageResponseModel(imageBytes));

        } catch (IOException e) {
            throw new InsertImageException("Error while passing to bytes.");
        } catch (SerialException e) {
            throw new InsertImageException("Error with Serialization");
        } catch (SQLException e) {
            throw new InsertImageException("Error while passing to Blob");
        } catch (NullPointerException e) {
            throw new UserIsNullException("This user does not exists");
        }
    }
}
