package com.blogapis.blogappforapis.controller;

import com.blogapis.blogappforapis.entities.Post;
import com.blogapis.blogappforapis.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    PostService postService;
    @PostMapping("/user/{userId}/category/{catId}/post")
public ResponseEntity<Post>createPosts(@RequestBody Post post, @PathVariable Long userId, @PathVariable Long catId){
    return new ResponseEntity<>(postService.createPost(post,catId,userId), HttpStatus.OK);
}

}
