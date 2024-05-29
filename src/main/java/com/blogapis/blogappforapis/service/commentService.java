package com.blogapis.blogappforapis.service;

import com.blogapis.blogappforapis.payload.CommentDTO;

public interface commentService {
CommentDTO addComment(CommentDTO commentDTO, Long postId);
void deleteComment(Long commentId);
}
