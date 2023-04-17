package com.blogging.blog_project.services;

import com.blogging.blog_project.dto.UserDTO;
import com.blogging.blog_project.entities.User;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO user);
    UserDTO updateUser(UserDTO user, Integer userId);
    UserDTO getUserById(Integer userId);
    List<UserDTO> getAllUsers();
    void deleteUser(Integer userId);
}
