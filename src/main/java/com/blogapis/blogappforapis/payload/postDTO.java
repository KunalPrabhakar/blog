package com.blogapis.blogappforapis.payload;

import com.blogapis.blogappforapis.entities.Categories;
import com.blogapis.blogappforapis.entities.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
@Data
public class postDTO {
    private String title;
    private String content;
    private catDTO categories;
    private UserDTO user;
    //private String image;
    //private Date dateofpost;
}
