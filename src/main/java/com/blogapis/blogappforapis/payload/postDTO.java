package com.blogapis.blogappforapis.payload;

import com.blogapis.blogappforapis.entities.Comment;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class postDTO {
    private Long postId;
    private String title;
    private String content;
    private catDTO categories;
    private UserDTO user;
    private List<CommentDTO> comments;
//  private Set<Comment>comments=new HashSet<>();
    //private String image;
    //private Date dateofpost;
}
