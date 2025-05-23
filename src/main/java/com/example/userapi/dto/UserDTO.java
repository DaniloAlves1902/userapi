package com.example.userapi.dto;

import com.example.userapi.model.User;

public record UserDTO(
        String username,
        String Email
) {
    public UserDTO(User user) {
        this(user.getUsername(), user.getEmail());
    }
}
