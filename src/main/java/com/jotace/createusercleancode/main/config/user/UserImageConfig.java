package com.jotace.createusercleancode.main.config.user;

import com.jotace.createusercleancode.application.gateway.user.UserImageGateway;
import com.jotace.createusercleancode.application.presenter.user.image.InsertImagePresenter;
import com.jotace.createusercleancode.application.usecases.user.UserImageInteractor;
import com.jotace.createusercleancode.core.boundary.user.UserImageBoundary;
import com.jotace.createusercleancode.infra.impl.gateway.user.image.UserImageGatewayImpl;
import com.jotace.createusercleancode.infra.impl.presenter.user.image.InsertImagePresenterImpl;
import com.jotace.createusercleancode.infra.mapper.user.UserMapper;
import com.jotace.createusercleancode.infra.persistence.user.UserEntityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserImageConfig {
    @Bean
    UserImageBoundary userImageBoundary(UserImageInteractor userImageInteractor) {
        return userImageInteractor;
    }
    @Bean
    UserImageInteractor userImageInteractor(UserImageGateway userImageGateway, InsertImagePresenter insertImagePresenter) {
        return new UserImageInteractor(userImageGateway, insertImagePresenter);
    }
    @Bean
    UserImageGateway userImageGateway(UserImageGatewayImpl userImageGateway) {
        return userImageGateway;
    }
    @Bean
    UserImageGatewayImpl userImageGatewayImpl(UserMapper userMapper, UserEntityRepository userEntityRepository) {
        return new UserImageGatewayImpl(userEntityRepository, userMapper);
    }
    @Bean
    InsertImagePresenter insertImagePresenter(InsertImagePresenterImpl insertImagePresenter) {
        return insertImagePresenter;
    }
    @Bean
    InsertImagePresenterImpl insertImagePresenterImpl() {
        return new InsertImagePresenterImpl();
    }
}
