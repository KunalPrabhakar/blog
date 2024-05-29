package com.blogapis.blogappforapis.payload;

import lombok.Data;

@Data
public class CommentDTO {
    private Long commentId;

    private String content;
  //  private postDTO post;
}
