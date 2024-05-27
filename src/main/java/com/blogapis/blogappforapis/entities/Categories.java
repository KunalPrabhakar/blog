package com.blogapis.blogappforapis.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catId;

private String catTitle;
private String catDesc;

@OneToMany(mappedBy = "categories",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
private List<Post> posts=new ArrayList<>();

}
