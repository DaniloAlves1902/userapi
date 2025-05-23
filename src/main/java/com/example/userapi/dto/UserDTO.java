package com.example.userapi.dto;

import com.example.userapi.model.User;

/**
 * Data Transfer Object (DTO) para representar dados essenciais do usuário.
 * Utilizado para transferir informações entre camadas, evitando expor toda a entidade User.
 *
 * @param username nome de usuário
 * @param Email email do usuário
 */
public record UserDTO(
        String username,
        String Email
) {
    /**
     * Construtor que cria um UserDTO a partir de um objeto User.
     *
     * @param user objeto User do qual extrai as informações de username e email.
     */
    public UserDTO(User user) {
        this(user.getUsername(), user.getEmail());
    }
}
