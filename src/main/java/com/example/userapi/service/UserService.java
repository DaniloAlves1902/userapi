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

/**
 * Serviço responsável pelas operações relacionadas à entidade User,
 * incluindo consultas, criação, atualização e exclusão de usuários.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Retorna uma lista de todos os usuários disponíveis, convertidos para UserDTO.
     *
     * @return lista de UserDTO contendo informações básicas dos usuários.
     */
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserDTO::new)
                .toList();
    }

    /**
     * Busca um usuário pelo seu ID e retorna seus dados como UserDTO.
     *
     * @param id identificador do usuário
     * @return UserDTO do usuário encontrado
     * @throws ResourceNotFoundException se nenhum usuário com o ID for encontrado
     */
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(UserDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("User not found or does not exists, by id " + id));
    }

    /**
     * Busca um usuário pelo seu nome de usuário (username).
     *
     * @param username nome de usuário para busca
     * @return UserDTO do usuário encontrado
     * @throws ResourceNotFoundException se nenhum usuário com o username for encontrado
     */
    public UserDTO getByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new ResourceNotFoundException("User with username '" + username + "' not found.");
        }
        return new UserDTO(user);
    }

    /**
     * Cria um novo usuário no sistema.
     *
     * Realiza validações para garantir que username e email sejam únicos,
     * lançando exceções caso contrário.
     *
     * @param user objeto User a ser criado
     * @return usuário criado persistido no banco
     * @throws DuplicateUsernameException se o username já existir
     * @throws DuplicateEmailException se o email já estiver registrado
     */
    public User createNewUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new DuplicateUsernameException("The username is already registered, choose another username");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateEmailException("The email is already registered, choose another username");
        }

        return userRepository.save(user);
    }

    /**
     * Atualiza os dados de um usuário existente identificado pelo ID.
     *
     * @param id identificador do usuário a ser atualizado
     * @param user objeto User com os dados atualizados
     * @return usuário atualizado persistido no banco
     * @throws ResourceNotFoundException se nenhum usuário com o ID for encontrado
     */
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setName(user.getName());
        existingUser.setPassword(user.getPassword());

        return userRepository.save(existingUser);
    }

    /**
     * Remove um usuário do sistema pelo seu ID.
     *
     * @param id identificador do usuário a ser removido
     * @throws ResourceNotFoundException se nenhum usuário com o ID for encontrado
     */
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found or does not exists, by id " + id);
        }

        userRepository.deleteById(id);
    }

}
