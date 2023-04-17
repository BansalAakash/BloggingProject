package com.blogging.blog_project.services.impl;

import com.blogging.blog_project.Repositories.UserRepository;
import com.blogging.blog_project.dto.UserDTO;
import com.blogging.blog_project.entities.User;
import com.blogging.blog_project.exceptions.ResourceNotFoundException.ResourceNotFoundException;
import com.blogging.blog_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = dtoToUser(userDTO);
        User user1 = userRepository.save(user);
        return userToDTO(user1);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setAbout(userDTO.getAbout());
        user.setPassword(userDTO.getPassword());
        return userToDTO(userRepository.save(user));
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        return userToDTO(userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId)));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(this::userToDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.delete(userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId)));
    }

    private User dtoToUser(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setAbout(userDTO.getAbout());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    private UserDTO userToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setAbout(user.getAbout());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }
}
