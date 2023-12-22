package com.jotace.createusercleancode.core.boundary.post;

import com.jotace.createusercleancode.core.model.post.SetPostImageModel;
import org.springframework.web.multipart.MultipartFile;

public interface PostImageBoundary {
    SetPostImageModel setPostImage(MultipartFile multipartFile, Long id);
}
