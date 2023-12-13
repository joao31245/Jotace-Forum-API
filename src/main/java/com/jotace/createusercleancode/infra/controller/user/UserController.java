package com.jotace.createusercleancode.infra.controller.user;

import com.jotace.createusercleancode.application.boundary.user.UserInputBoundary;
import com.jotace.createusercleancode.application.model.user.UserRequestModel;
import com.jotace.createusercleancode.application.model.user.UserResponseModel;
import com.jotace.createusercleancode.application.model.user.UserUpdateRequestModel;
import com.jotace.createusercleancode.application.model.user.UserUpdateResponseModel;
import jakarta.validation.Valid;
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
    public ResponseEntity<UserResponseModel> createUser(@RequestBody @Valid UserRequestModel userRequestModel) {
       return ResponseEntity.ok(userInputBoundary.create(userRequestModel));
    }
    @GetMapping
    public ResponseEntity<List<UserResponseModel>> getAllUsers() {
        return ResponseEntity.ok(userInputBoundary.getAllUsers());
    }
    @PutMapping
    public ResponseEntity<UserUpdateResponseModel> updateUser(@RequestBody @Valid UserUpdateRequestModel requestModel) {
       return ResponseEntity.ok(userInputBoundary.update(requestModel));
    }
    @GetMapping("{id}")
    public ResponseEntity<UserResponseModel> findUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userInputBoundary.findUserById(id));
    }

}
