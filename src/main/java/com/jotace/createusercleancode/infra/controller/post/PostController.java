package com.jotace.createusercleancode.infra.controller.post;

import com.jotace.createusercleancode.application.boundary.post.PostInputBoundary;
import com.jotace.createusercleancode.application.model.post.PostRequestModel;
import com.jotace.createusercleancode.application.model.post.PostResponseModel;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("post")
public class PostController {
    private final PostInputBoundary postInputBoundary;

    public PostController(PostInputBoundary postInputBoundary) {
        this.postInputBoundary = postInputBoundary;
    }

    @PostMapping
    public ResponseEntity<PostResponseModel> createPost(@RequestBody @Valid PostRequestModel postRequestModel) {
        return ResponseEntity.ok(this.postInputBoundary.create(postRequestModel));
    }
}
