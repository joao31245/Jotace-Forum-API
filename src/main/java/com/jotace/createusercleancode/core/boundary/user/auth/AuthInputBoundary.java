package com.jotace.createusercleancode.core.boundary.user.auth;

import com.jotace.createusercleancode.core.model.auth.AuthRequestModel;
import com.jotace.createusercleancode.core.model.auth.AuthResponseModel;

import javax.naming.AuthenticationException;

public interface AuthInputBoundary {
    AuthResponseModel login(AuthRequestModel AuthRequestModel) throws AuthenticationException;
}
