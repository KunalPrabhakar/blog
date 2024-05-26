package com.blogapis.blogappforapis.service;

import com.blogapis.blogappforapis.Repository.UserRepo;
import com.blogapis.blogappforapis.payload.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
public interface Userservice{
UserDTO createUser(UserDTO user);
UserDTO updateUser(UserDTO user, Long id);
UserDTO getUser(Long id);
List<UserDTO> getAllUsers();
void deleteUser(Long id);
}
