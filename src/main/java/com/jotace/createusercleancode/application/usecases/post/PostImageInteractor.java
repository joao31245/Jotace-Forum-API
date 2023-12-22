package com.jotace.createusercleancode.application.usecases.post;

import com.jotace.createusercleancode.application.gateway.post.PostImageGateway;
import com.jotace.createusercleancode.application.presenter.post.InsertPostImagePresenter;
import com.jotace.createusercleancode.application.presenter.user.image.InsertImagePresenter;
import com.jotace.createusercleancode.core.boundary.post.PostImageBoundary;
import com.jotace.createusercleancode.core.exception.InsertImageException;
import com.jotace.createusercleancode.core.exception.UserIsNullException;
import com.jotace.createusercleancode.core.model.post.SetPostImageModel;
import com.jotace.createusercleancode.core.model.user.SetProfileImageResponseModel;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.SQLException;

public class PostImageInteractor implements PostImageBoundary {

    private final PostImageGateway postImageGateway;
    private final InsertPostImagePresenter insertPostImagePresenter;

    public PostImageInteractor(PostImageGateway postImageGateway, InsertPostImagePresenter insertPostImagePresenter) {
        this.postImageGateway = postImageGateway;
        this.insertPostImagePresenter = insertPostImagePresenter;
    }

    @Override
    public SetPostImageModel setPostImage(MultipartFile multipartFile, Long id) {
        try {
            var fileBytes = multipartFile.getBytes();
            var image = new javax.sql.rowset.serial.SerialBlob(fileBytes);

            var userImage = postImageGateway.setImage(id, image);
            var imageBytes = userImage.getBytes(1, (int) image.length());

            return insertPostImagePresenter.prepareSuccessView(new SetPostImageModel(imageBytes));

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
