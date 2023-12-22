package com.jotace.createusercleancode.main.config.post;

import com.jotace.createusercleancode.application.gateway.post.PostImageGateway;
import com.jotace.createusercleancode.application.presenter.post.InsertPostImagePresenter;
import com.jotace.createusercleancode.application.usecases.post.PostImageInteractor;
import com.jotace.createusercleancode.core.boundary.post.PostImageBoundary;
import com.jotace.createusercleancode.infra.impl.gateway.post.PostImageGatewayImpl;
import com.jotace.createusercleancode.infra.impl.presenter.post.InsertPostImagePresenterImpl;
import com.jotace.createusercleancode.infra.mapper.post.PostMapper;
import com.jotace.createusercleancode.infra.persistence.post.PostEntity;
import com.jotace.createusercleancode.infra.persistence.post.PostEntityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostImageConfig {

    @Bean
    PostImageBoundary postImageBoundary(PostImageInteractor postImageInteractor) {
        return postImageInteractor;
    }
    @Bean
    PostImageInteractor postImageInteractor(PostImageGateway postImageGateway,
                                            InsertPostImagePresenter insertPostImagePresenter) {
        return new PostImageInteractor(postImageGateway, insertPostImagePresenter);
    }
    @Bean
    PostImageGateway postImageGateway(PostImageGatewayImpl postImageGateway) {
        return postImageGateway;
    }
    @Bean
    PostImageGatewayImpl postImageGatewayImpl(PostEntityRepository postEntityRepository, PostMapper postMapper) {
        return new PostImageGatewayImpl(postEntityRepository, postMapper);
    }

    @Bean
    InsertPostImagePresenter insertPostImagePresenter(InsertPostImagePresenterImpl insertPostImagePresenter) {
        return insertPostImagePresenter;
    }
    @Bean
    InsertPostImagePresenterImpl insertPostImagePresenterImpl() {
        return new InsertPostImagePresenterImpl();
    }
}
