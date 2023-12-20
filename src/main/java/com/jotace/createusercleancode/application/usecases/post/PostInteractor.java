package com.jotace.createusercleancode.application.usecases.post;

import com.jotace.createusercleancode.application.gateway.post.FindUserGateway;
import com.jotace.createusercleancode.core.boundary.post.PostInputBoundary;
import com.jotace.createusercleancode.application.gateway.post.PostGateway;
import com.jotace.createusercleancode.application.presenter.post.CreatePostPresenter;
import com.jotace.createusercleancode.core.entity.post.CommonPostFactory;
import com.jotace.createusercleancode.core.model.post.PostRequestModel;
import com.jotace.createusercleancode.core.model.post.PostResponseModel;
import com.jotace.createusercleancode.core.model.post.PostUpdateRequestModel;
import com.jotace.createusercleancode.core.model.post.PostUpdateResponseModel;
import com.jotace.createusercleancode.core.exception.UserIsNullException;

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
        try{
            var user = findUserGateway.findUserById(postRequestModel.ownerId());
            var post = new CommonPostFactory().create(postRequestModel.title(), postRequestModel.image(),
                    postRequestModel.description(),user, postRequestModel.postCategory());

            post = postGateway.save(post);

            return createPostPresenter.prepareSuccessView(new PostResponseModel(post));
        } catch (NullPointerException exception) {
            throw new UserIsNullException("User is null");
        }



    }

    @Override
    public PostResponseModel findPostById(Long id) {
        var post = postGateway.findPostById(id);

        if(post == null) {
            return createPostPresenter.prepareFailView("Post Not found");
        }

        return createPostPresenter.prepareSuccessView(new PostResponseModel(post));
    }

    @Override
    public List<PostResponseModel> getAllPosts() {
        var posts = postGateway.getAllPosts();

        return posts.stream().map(PostResponseModel::new).toList();
    }

    @Override
    public void delete(Long id) {
        postGateway.delete(id);
    }

    @Override
    public PostUpdateResponseModel update(PostUpdateRequestModel requestModel) {
        var post = postGateway.update(requestModel);

        return new PostUpdateResponseModel(post);
    }

}
