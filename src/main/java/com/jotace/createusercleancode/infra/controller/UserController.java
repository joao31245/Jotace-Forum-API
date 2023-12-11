package com.jotace.createusercleancode.infra.controller;

import com.jotace.createusercleancode.application.boundary.UserInputBoundary;
import com.jotace.createusercleancode.application.model.UserRequestModel;
import com.jotace.createusercleancode.application.model.UserResponseModel;
import com.jotace.createusercleancode.application.model.UserUpdateRequestModel;
import com.jotace.createusercleancode.application.model.UserUpdateResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserInputBoundary userInputBoundary;
    public UserController(UserInputBoundary userInputBoundary) {
        this.userInputBoundary = userInputBoundary;
    }

    @PostMapping
    public ResponseEntity<UserResponseModel> createUser(@RequestBody UserRequestModel userRequestModel) {
       return ResponseEntity.ok(userInputBoundary.create(userRequestModel));
    }
    @GetMapping
    public ResponseEntity<List<UserResponseModel>> getAllUsers() {
        return ResponseEntity.ok(userInputBoundary.getAllUsers());
    }
    @PutMapping
    public ResponseEntity<UserUpdateResponseModel> updateUser(@RequestBody UserUpdateRequestModel requestModel) {
       return ResponseEntity.ok(userInputBoundary.update(requestModel));
    }

}
