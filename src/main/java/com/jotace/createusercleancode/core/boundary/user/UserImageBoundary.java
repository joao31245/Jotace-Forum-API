package com.jotace.createusercleancode.core.boundary.user;

import com.jotace.createusercleancode.core.entity.user.User;
import com.jotace.createusercleancode.core.model.user.SetProfileImageResponseModel;
import org.springframework.web.multipart.MultipartFile;

public interface UserImageBoundary {
    SetProfileImageResponseModel setProfileImage(MultipartFile multipartFile, Long id);
}
