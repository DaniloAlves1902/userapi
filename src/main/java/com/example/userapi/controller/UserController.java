package com.example.userapi.controller;

import com.example.userapi.dto.UserDTO;
import com.example.userapi.model.User;
import com.example.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gerenciar operações relacionadas a usuários.
 * Fornece endpoints para listar, buscar, criar, atualizar e deletar usuários.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Retorna uma lista de todos os usuários disponíveis no sistema.
     *
     * @return lista de UserDTO contendo informações dos usuários.
     */
    @GetMapping
    public List<UserDTO> listAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Busca um usuário pelo seu ID.
     *
     * @param id ID do usuário a ser buscado.
     * @return UserDTO contendo informações do usuário encontrado.
     */
    @GetMapping("{id}")
    public UserDTO listUserByEmail(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    /**
     * Busca um usuário pelo seu nome de usuário (username).
     *
     * @param username Nome de usuário a ser buscado.
     * @return UserDTO contendo informações do usuário encontrado.
     */
    @GetMapping("/username/{username}")
    public UserDTO listByUsername(@PathVariable String username) {
        return userService.getByUsername(username);
    }

    /**
     * Cria um novo usuário no sistema.
     *
     * @param user Objeto User contendo os dados do novo usuário.
     * @return ResponseEntity contendo o usuário criado e o status HTTP CREATED (201).
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.createNewUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    /**
     * Atualiza os dados de um usuário existente.
     *
     * @param id ID do usuário a ser atualizado.
     * @param user Objeto User com os dados atualizados.
     * @return Usuário atualizado.
     */
    @PutMapping("{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    /**
     * Remove um usuário do sistema.
     *
     * @param id ID do usuário a ser deletado.
     */
    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
