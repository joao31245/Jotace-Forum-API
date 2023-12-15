package com.jotace.createusercleancode.application.usecases.auth;

import com.jotace.createusercleancode.core.boundary.user.auth.AuthInputBoundary;
import com.jotace.createusercleancode.application.gateway.user.auth.AuthGateway;
import com.jotace.createusercleancode.application.model.auth.AuthRequestModel;
import com.jotace.createusercleancode.application.model.auth.AuthResponseModel;
import com.jotace.createusercleancode.application.presenter.user.auth.LoginUserPresenter;
import org.springframework.security.core.AuthenticationException;


public class AuthInteractor implements AuthInputBoundary {

    private final AuthGateway authGateway;

    private final LoginUserPresenter loginUserPresenter;
    public AuthInteractor(AuthGateway authGateway, LoginUserPresenter loginUserPresenter) {
        this.authGateway = authGateway;
        this.loginUserPresenter = loginUserPresenter;
    }

    @Override
    public AuthResponseModel login(AuthRequestModel requestModel) throws AuthenticationException {
        var email = requestModel.email();

        var user = authGateway.findUserByEmail(email);

        if(user == null) {
            return loginUserPresenter.prepareFailView("this user does not exists");
        }

        var token = authGateway.generateAuthenticationToken(requestModel);

        return loginUserPresenter.prepareSuccessView(new AuthResponseModel(token));
    }
}
