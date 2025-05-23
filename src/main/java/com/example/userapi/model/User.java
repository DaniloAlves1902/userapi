package com.example.userapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * Representa um usuário do sistema.
 *
 * Esta entidade é mapeada para a tabela "user" no banco de dados.
 * Contém informações básicas do usuário, como nome, username, email e senha.
 */
@Entity
@Table(name = "\"user\"")
public class User {

    /**
     * Identificador único do usuário.
     * Gerado automaticamente pelo banco.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome completo do usuário.
     * Não pode estar em branco.
     */
    @NotBlank(message = "Name is required")
    private String name;

    /**
     * Nome de usuário (username) utilizado para login.
     * Deve ser único e não pode estar em branco.
     */
    @NotBlank(message = "username is required")
    @Column(nullable = false, unique = true)
    private String username;

    /**
     * Email do usuário.
     * Deve ser único, válido e não pode estar em branco.
     */
    @NotBlank(message = "email is required")
    @Column(nullable = false, unique = true)
    @Email
    private String email;

    /**
     * Senha do usuário.
     * Não pode estar em branco.
     */
    @NotBlank(message = "password is required")
    private String password;

    /**
     * Construtor padrão necessário para JPA.
     */
    public User() {}

    /**
     * Construtor completo da entidade User.
     *
     * @param id identificador do usuário
     * @param email email do usuário
     * @param name nome completo do usuário
     * @param username nome de usuário para login
     * @param password senha do usuário
     */
    public User(Long id, String email, String name, String username, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    /**
     * Obtém o identificador único do usuário.
     *
     * @return id do usuário
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o identificador único do usuário.
     *
     * @param id novo id do usuário
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o nome completo do usuário.
     *
     * @return nome do usuário
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome completo do usuário.
     *
     * @param name novo nome do usuário
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém o nome de usuário (username).
     *
     * @return username do usuário
     */
    public String getUsername() {
        return username;
    }

    /**
     * Define o nome de usuário (username).
     *
     * @param username novo username do usuário
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtém o email do usuário.
     *
     * @return email do usuário
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do usuário.
     *
     * @param email novo email do usuário
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém a senha do usuário.
     *
     * @return senha do usuário
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define a senha do usuário.
     *
     * @param password nova senha do usuário
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
