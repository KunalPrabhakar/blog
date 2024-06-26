package com.blogapis.blogappforapis.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Entity
@Table(name = "posts")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long postId;
    private String title;
    @Column(length = 1000)
    private String content;
    private String image;
    private Date dateofpost;
    @ManyToOne
    @JoinColumn(name = "category_Id")
    private Categories categories;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    private User user;


    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private List<Comment> comments=new ArrayList<>();

}
