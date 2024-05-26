package com.blogapis.blogappforapis.service.impl;

import com.blogapis.blogappforapis.Repository.UserRepo;
import com.blogapis.blogappforapis.entities.User;
import com.blogapis.blogappforapis.payload.UserDTO;
import com.blogapis.blogappforapis.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements Userservice {
    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDTO createUser(UserDTO userDTO) {

        User savedUser=userRepo.save(convertFromUserDTO(userDTO));

        return convertFromUser(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long id) {
User user=userRepo.findById(id).orElse(null);
user.setName(userDTO.getName());
user.setEmail(userDTO.getEmail());
user.setPassword(userDTO.getPassword());
user.setAbout(userDTO.getAbout());
User savedUser=userRepo.save(user);
        return convertFromUser(savedUser);
    }

    @Override
    public UserDTO getUser(Long id) {
        return convertFromUser(userRepo.findById(id).orElse(null));
    }

    @Override
    public List<UserDTO> getAllUsers() {
       List<UserDTO> userDTOs = userRepo.findAll().stream()
    .map(this::convertFromUser)
    .collect(Collectors.toList());

        return userDTOs;
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }


    private User convertFromUserDTO(UserDTO userDTO) {
    User user=new User();
    user.setId(userDTO.getId());
    user.setName(userDTO.getName());
    user.setEmail(userDTO.getEmail());
    user.setPassword(userDTO.getPassword());
    user.setAbout(userDTO.getAbout());
    return user;
}
private UserDTO convertFromUser(User user) {
    UserDTO userDTO = new UserDTO();
    userDTO.setId(user.getId());
    userDTO.setName(user.getName());
    userDTO.setEmail(user.getEmail());
    userDTO.setPassword(user.getPassword());
    userDTO.setAbout(user.getAbout());
    return userDTO;
    }
}
