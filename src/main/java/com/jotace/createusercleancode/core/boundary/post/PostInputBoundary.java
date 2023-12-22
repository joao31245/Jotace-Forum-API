package com.jotace.createusercleancode.core.boundary.post;

import com.jotace.createusercleancode.core.model.post.PostRequestModel;
import com.jotace.createusercleancode.core.model.post.PostResponseModel;
import com.jotace.createusercleancode.core.model.post.PostUpdateRequestModel;
import com.jotace.createusercleancode.core.model.post.PostUpdateResponseModel;

import java.sql.SQLException;
import java.util.List;

public interface PostInputBoundary {
    PostResponseModel create(PostRequestModel postRequestModel) throws SQLException;
    PostResponseModel findPostById(Long id) throws SQLException;
    List<PostResponseModel> getAllPosts();
    void delete(Long id);
    PostUpdateResponseModel update(PostUpdateRequestModel requestModel);

}
