package com.jotace.createusercleancode.infra.controller.post;

import com.jotace.createusercleancode.core.boundary.post.PostImageBoundary;
import com.jotace.createusercleancode.core.boundary.post.PostInputBoundary;
import com.jotace.createusercleancode.core.model.post.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {
    private final PostInputBoundary postInputBoundary;

    private final PostImageBoundary postImageBoundary;

    public PostController(PostInputBoundary postInputBoundary, PostImageBoundary postImageBoundary) {
        this.postInputBoundary = postInputBoundary;
        this.postImageBoundary = postImageBoundary;
    }

    @PostMapping
    public ResponseEntity<PostResponseModel> createPost(@RequestBody @Valid PostRequestModel postRequestModel) throws SQLException {
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
    public ResponseEntity<PostResponseModel> getById(@PathVariable Long id) throws SQLException {
        return ResponseEntity.ok(postInputBoundary.findPostById(id));
    }

    @GetMapping
    public ResponseEntity<List<PostResponseModel>> getAll() {
        return ResponseEntity.ok(postInputBoundary.getAllPosts());
    }

    @PutMapping("image/{id}")
    public ResponseEntity<SetPostImageModel> setPostImage(
            @PathVariable Long id,
            @RequestPart("image")MultipartFile multipartFile
    ) {
        return ResponseEntity.ok(postImageBoundary.setPostImage(multipartFile, id));
    }


}
