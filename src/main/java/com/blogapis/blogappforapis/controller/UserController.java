package com.blogapis.blogappforapis.controller;

import com.blogapis.blogappforapis.payload.UserDTO;
import com.blogapis.blogappforapis.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
private Userservice Userservice;
    @PostMapping("/")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
UserDTO createUserDto = Userservice.createUser(userDTO);
        return new ResponseEntity<>(createUserDto, HttpStatus.OK);
    }

    @PutMapping("/{userID}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO,@PathVariable Long userID){
        UserDTO updateUserDTO = Userservice.updateUser(userDTO,userID);
        return new ResponseEntity<>(updateUserDTO, HttpStatus.OK);
    }
    @DeleteMapping("/{userID}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userID){
        Userservice.deleteUser(userID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/finduser/{userID}")
    public ResponseEntity<UserDTO> getUserbyid(@PathVariable Long userID){
        UserDTO user=  Userservice.getUser(userID);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<UserDTO>> getUser(){
        List<UserDTO>allusers=  Userservice.getAllUsers();
        return new ResponseEntity<>(allusers, HttpStatus.OK);
    }

}
