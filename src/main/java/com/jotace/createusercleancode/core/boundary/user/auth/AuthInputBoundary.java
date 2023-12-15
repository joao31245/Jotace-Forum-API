package com.jotace.createusercleancode.core.boundary.user.auth;

import com.jotace.createusercleancode.application.model.auth.AuthRequestModel;
import com.jotace.createusercleancode.application.model.auth.AuthResponseModel;

import javax.naming.AuthenticationException;

public interface AuthInputBoundary {
    AuthResponseModel login(AuthRequestModel AuthRequestModel) throws AuthenticationException;
}
