package com.jotace.createusercleancode.application.usecases.post;

import com.jotace.createusercleancode.application.gateway.post.FindUserGateway;
import com.jotace.createusercleancode.application.boundary.post.PostInputBoundary;
import com.jotace.createusercleancode.application.gateway.post.PostGateway;
import com.jotace.createusercleancode.application.model.post.PostRequestModel;
import com.jotace.createusercleancode.application.model.post.PostResponseModel;
import com.jotace.createusercleancode.application.model.post.PostUpdateRequestModel;
import com.jotace.createusercleancode.application.model.post.PostUpdateResponseModel;
import com.jotace.createusercleancode.application.presenter.post.CreatePostPresenter;
import com.jotace.createusercleancode.core.entity.post.CommonPostFactory;

import java.util.List;

public class PostInteractor implements PostInputBoundary {
    private final PostGateway postGateway;
    private final CreatePostPresenter createPostPresenter;

    private final FindUserGateway findUserGateway;

    public PostInteractor(PostGateway postGateway, CreatePostPresenter createPostPresenter, FindUserGateway fIndUserGateway) {
        this.postGateway = postGateway;
        this.createPostPresenter = createPostPresenter;
        this.findUserGateway = fIndUserGateway;
    }

    @Override
    public PostResponseModel create(PostRequestModel postRequestModel) {
        var user = findUserGateway.findUserById(postRequestModel.ownerId());

        var post = new CommonPostFactory().create(postRequestModel.title(), postRequestModel.image(),
                postRequestModel.description(),user, postRequestModel.postCategory());

        post = postGateway.save(post);

        return createPostPresenter.prepareSuccessView(new PostResponseModel(post));
    }

    @Override
    public List<PostResponseModel> findPostByOwnerId(Long ownerId) {
        return null;
    }

    @Override
    public List<PostResponseModel> getAllPosts() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public PostUpdateResponseModel update(PostUpdateRequestModel requestModel) {

        var post = postGateway.update(requestModel);

        return new PostUpdateResponseModel(post);
    }

}
