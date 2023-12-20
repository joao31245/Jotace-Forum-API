package com.jotace.createusercleancode.infra.controller.auth;

import com.jotace.createusercleancode.core.boundary.user.auth.AuthInputBoundary;
import com.jotace.createusercleancode.core.model.auth.AuthRequestModel;
import com.jotace.createusercleancode.core.model.auth.AuthResponseModel;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthInputBoundary authInputBoundary;

    public AuthenticationController(AuthInputBoundary authInputBoundary) {
        this.authInputBoundary = authInputBoundary;
    }

    @GetMapping("/login")
    public ResponseEntity<AuthResponseModel> login(@RequestBody @Valid AuthRequestModel requestModel) throws AuthenticationException {
        return ResponseEntity.ok(authInputBoundary.login(requestModel));
    }
}
