package com.jotace.createusercleancode.infra.controller.user;

import com.jotace.createusercleancode.core.boundary.user.UserImageBoundary;
import com.jotace.createusercleancode.core.boundary.user.UserInputBoundary;
import com.jotace.createusercleancode.core.model.user.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "user", produces = ("application/json"))
@Tag(name = "Jotace forum")
public class UserController {
    private final UserInputBoundary userInputBoundary;

    private final UserImageBoundary userImageBoundary;
    public UserController(UserInputBoundary userInputBoundary, UserImageBoundary userImageBoundary) {
        this.userInputBoundary = userInputBoundary;
        this.userImageBoundary = userImageBoundary;
    }
    @PostMapping("/register")
    @Transactional
    @Operation(summary = "Create a new User", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Worked!"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            @ApiResponse(responseCode = "400", description = "Validation error"),
            @ApiResponse(responseCode = "403", description = "Authentication error")

    })
    public ResponseEntity<UserResponseModel> createUser(@RequestBody @Valid UserRequestModel userRequestModel) throws SQLException {
       return ResponseEntity.ok(userInputBoundary.create(userRequestModel));
    }

    @GetMapping
    @Transactional
    @Operation(summary = "Get all users", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Worked!"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            @ApiResponse(responseCode = "403", description = "Authentication error")
    })
    public ResponseEntity<List<UserResponseModel>> getAllUsers() throws SQLException {
        return ResponseEntity.ok(userInputBoundary.getAllUsers());
    }
    @PutMapping
    @Transactional
    @Operation(summary = "Update a specific user", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Worked!"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            @ApiResponse(responseCode = "403", description = "Authentication error")

    })
    public ResponseEntity<UserUpdateResponseModel> updateUser(@RequestBody @Valid UserUpdateRequestModel requestModel) {
       return ResponseEntity.ok(userInputBoundary.update(requestModel));
    }
    @GetMapping("{id}")
    @Operation(summary = "Get a specific user", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Worked!"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            @ApiResponse(responseCode = "403", description = "Authentication error"),
            @ApiResponse(responseCode = "404", description = "User not found")

    })
    public ResponseEntity<UserResponseModel> findUserById(@PathVariable Long id) throws SQLException {
        return ResponseEntity.ok(userInputBoundary.findUserById(id));
    }

    @DeleteMapping("{id}")
    @GetMapping("{id}")
    @Operation(summary = "Get a specific user", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Worked!"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            @ApiResponse(responseCode = "403", description = "Authentication error"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity deleteUserById(@PathVariable Long id) {
        userInputBoundary.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Insert a profile image", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Worked!"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            @ApiResponse(responseCode = "403", description = "Authentication error"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })

    @PutMapping("/image/{id}")
    public ResponseEntity<SetProfileImageResponseModel> setProfileImage(
            @PathVariable Long id,
            @RequestPart("image")MultipartFile multipartFile) {

        return ResponseEntity.ok(userImageBoundary.setProfileImage(multipartFile, id));

    }
}
