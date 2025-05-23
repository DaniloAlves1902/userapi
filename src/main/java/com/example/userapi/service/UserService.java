package com.example.userapi.service;

import com.example.userapi.dto.UserDTO;
import com.example.userapi.exeception.DuplicateEmailException;
import com.example.userapi.exeception.DuplicateUsernameException;
import com.example.userapi.exeception.ResourceNotFoundException;
import com.example.userapi.model.User;
import com.example.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserDTO::new)
                .toList();
    }

    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(UserDTO::new)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User not found or does not exists, by id " + id)
                );
    }

    public UserDTO getByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new ResourceNotFoundException("User with username '" + username + "' not found.");
        }
        return new UserDTO(user);
    }

    public User createNewUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new DuplicateUsernameException("The username is already registered, choose another username");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateEmailException("The email is already registered, choose another username");
        }

        return userRepository.save(user);

    }

    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User not found with id " + id));

        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setName(user.getName());
        existingUser.setPassword(user.getPassword());

        return userRepository.save(existingUser);
    }


    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found or does not exists, by id " + id);
        }

        userRepository.deleteById(id);
    }


}
