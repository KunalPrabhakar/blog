package com.blogapis.blogappforapis.controller;

import com.blogapis.blogappforapis.entities.Post;
import com.blogapis.blogappforapis.payload.postDTO;
import com.blogapis.blogappforapis.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    PostService postService;
    @PostMapping("/user/{userId}/category/{catId}/post")
//    @CrossOrigin(origins = "http://localhost:3000") // Replace with your frontend URL
    public ResponseEntity<postDTO>createPosts(@RequestBody postDTO post, @PathVariable Long userId, @PathVariable Long catId){
    return new ResponseEntity<>(postService.createPost(post,catId,userId), HttpStatus.OK);
}

@GetMapping("/findByUser/{userId}")
public  ResponseEntity<List<postDTO>>getPostsByuser(@PathVariable Long userId){
    return new ResponseEntity<>(postService.getAllPostByUser(userId),HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public  ResponseEntity<postDTO>getPostById(@PathVariable Long postId){
        return new ResponseEntity<>(postService.getPostById(postId),HttpStatus.OK);
    }


    @GetMapping("/findByCategory/{catId}")
    public  ResponseEntity<List<postDTO>>getPostsByCat(@PathVariable Long catId){
        return new ResponseEntity<>(postService.getAllPostByCategory(catId),HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public  ResponseEntity deletePostById(@PathVariable Long postId){
        postService.deletePost(postId);
        return new ResponseEntity (HttpStatus.OK);
    }

    @GetMapping("/search/{keyword}")
    public  ResponseEntity<List<postDTO>>searchPosts(@PathVariable String keyword){
        return new ResponseEntity<>(postService.searchPosts(keyword),HttpStatus.OK);
    }

@GetMapping
    public ResponseEntity<List<postDTO>>getAllPosts(@RequestParam(value="pageNumber",defaultValue ="0",required = false) Integer pageNumber,@RequestParam(value="pageSize",defaultValue = "5",required = false) Integer pageSize){
        return new ResponseEntity<>(postService.getAllPost(pageNumber,pageSize),HttpStatus.OK);
    }

}
