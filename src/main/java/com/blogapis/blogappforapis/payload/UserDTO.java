package com.blogapis.blogappforapis.payload;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;


    private String name;


    private String email;


    private String password;

    private String about;

    private String imageName;
}
