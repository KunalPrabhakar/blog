package com.blogapis.blogappforapis.service.impl;

import com.blogapis.blogappforapis.Repository.CommentRepo;
import com.blogapis.blogappforapis.Repository.PostRepo;
import com.blogapis.blogappforapis.entities.Comment;
import com.blogapis.blogappforapis.entities.Post;
import com.blogapis.blogappforapis.payload.CommentDTO;
import com.blogapis.blogappforapis.service.commentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements commentService {
@Autowired
    PostRepo postRepo;
    @Autowired
CommentRepo commentRepo;
@Autowired
private ModelMapper modelMapper;
    @Override
    public CommentDTO   addComment(CommentDTO commentDTO, Long postId) {
        Post post=this.postRepo.findById(postId).orElse(null);
        Comment comment=   this.modelMapper.map(commentDTO, Comment.class);
        comment.setPost(post);
   Comment savedComment= commentRepo.save(comment);
    return this.modelMapper.map(savedComment,CommentDTO.class);
    }

    @Override
    public void deleteComment(Long commentId) {
commentRepo.deleteById(commentId);
    }
}
