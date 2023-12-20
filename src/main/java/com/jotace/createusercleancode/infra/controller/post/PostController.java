package com.jotace.createusercleancode.infra.controller.post;

import com.jotace.createusercleancode.core.boundary.post.PostInputBoundary;
import com.jotace.createusercleancode.core.model.post.PostRequestModel;
import com.jotace.createusercleancode.core.model.post.PostResponseModel;
import com.jotace.createusercleancode.core.model.post.PostUpdateRequestModel;
import com.jotace.createusercleancode.core.model.post.PostUpdateResponseModel;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping
    public ResponseEntity<PostUpdateResponseModel> updatePost(@RequestBody @Valid
                                                            PostUpdateRequestModel postUpdateRequestModel) {
        return ResponseEntity.ok(postInputBoundary.update(postUpdateRequestModel));
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        postInputBoundary.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<PostResponseModel> getById(@PathVariable Long id) {
        return ResponseEntity.ok(postInputBoundary.findPostById(id));
    }

    @GetMapping
    public ResponseEntity<List<PostResponseModel>> getAll() {
        return ResponseEntity.ok(postInputBoundary.getAllPosts());
    }

}
