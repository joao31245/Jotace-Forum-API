package com.jotace.createusercleancode.application.boundary.post;

import com.jotace.createusercleancode.application.model.post.PostRequestModel;
import com.jotace.createusercleancode.application.model.post.PostResponseModel;
import com.jotace.createusercleancode.application.model.post.PostUpdateRequestModel;
import com.jotace.createusercleancode.application.model.post.PostUpdateResponseModel;

import java.util.List;

public interface PostInputBoundary {
    PostResponseModel create(PostRequestModel postRequestModel);
    List<PostResponseModel> findPostByOwnerId(Long ownerId);
    List<PostResponseModel> getAllPosts();
    void delete(Long id);
    PostUpdateResponseModel update(PostUpdateRequestModel requestModel);

}
