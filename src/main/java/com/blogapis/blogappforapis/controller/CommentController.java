package com.blogapis.blogappforapis.controller;

import com.blogapis.blogappforapis.payload.CommentDTO;
import com.blogapis.blogappforapis.service.commentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    private commentService commentService;

    @PostMapping("/{postId}")
    public ResponseEntity<CommentDTO> addComment(@RequestBody CommentDTO  commentDTO,@PathVariable Long postId) {
        return  new ResponseEntity<>(commentService.addComment(commentDTO,postId), HttpStatus.CREATED);
    }
}
