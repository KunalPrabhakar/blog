package com.blogapis.blogappforapis.controller;

import com.blogapis.blogappforapis.payload.UserDTO;
import com.blogapis.blogappforapis.service.FileService;
import com.blogapis.blogappforapis.service.Userservice;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
private Userservice Userservice;
    @Autowired
    private FileService fileService;
    @Value("${project.image}")
    private String path;
    @PostMapping("/")
    @CrossOrigin(origins = "http://localhost:3000") // Replace with your frontend URL
    public ResponseEntity<UserDTO> createUser(@RequestParam String name,
                                              @RequestParam String email,
                                              @RequestParam String password,
                                              @RequestParam String about,
                                              @RequestParam("image")MultipartFile image) throws IOException {

        // Upload the image and get the file name
        String fileName = fileService.uploadImage(path, image);
UserDTO userDTO=new UserDTO();
userDTO.setName(name);
userDTO.setEmail(email);
userDTO.setPassword(password);
userDTO.setAbout(about);
        // Set the image name in the UserDTO
        userDTO.setImageName(fileName);

        // Create the user
        UserDTO createUserDto = Userservice.createUser(userDTO);

        // Return the response entity
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


    @PostMapping("/image/upload/{userID}")
public ResponseEntity<UserDTO> uploadPostImage(@RequestParam("image")MultipartFile image,@PathVariable Long userID) throws IOException {
String fileName=fileService.uploadImage(path,image);
        UserDTO userDTO=  Userservice.getUser(userID);
            userDTO.setImageName(fileName);
        Userservice.updateUser(userDTO,userID);
return  new ResponseEntity<>(userDTO,HttpStatus.OK);

}

    @GetMapping(value = "/profiles/{imageName}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
public void downloadImage(@PathVariable("imageName") String imageName, HttpServletResponse response) throws Exception {
        InputStream resource=fileService.getResource(path,imageName);
        //Resource imageResource = new UrlResource(imagePath.toUri());

        if (imageName!=null) {
            // Determine the content type based on the file extension
            String contentType;
            if (imageName.endsWith(".jpg") || imageName.endsWith(".jpeg")) {
                contentType = MediaType.IMAGE_JPEG_VALUE;
            } else if (imageName.endsWith(".png")) {
                contentType = MediaType.IMAGE_PNG_VALUE;
            } else {
                throw new Exception("Unsupported image type");
            }

            // Set the content type in the response
            response.setContentType(contentType);
            StreamUtils.copy(resource,response.getOutputStream());
        } else {
            throw new Exception("Image not found or not readable");
        }
    }

}
