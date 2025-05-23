package com.example.userapi.repository;

import com.example.userapi.dto.UserDTO;
import com.example.userapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para manipulação dos dados da entidade User.
 *
 * Extende JpaRepository para fornecer operações CRUD e consultas específicas.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Busca um usuário pelo seu nome de usuário (username).
     *
     * @param username nome de usuário a ser buscado.
     * @return instância do usuário correspondente ao username informado,
     *         ou null se não encontrado.
     */
    User findByUsername(String username);

    /**
     * Verifica se já existe um usuário com o username informado.
     *
     * @param userName nome de usuário a ser verificado.
     * @return true se existir um usuário com o username, false caso contrário.
     */
    Boolean existsByUsername(String userName);

    /**
     * Verifica se já existe um usuário com o email informado.
     *
     * @param Email email a ser verificado.
     * @return true se existir um usuário com o email, false caso contrário.
     */
    Boolean existsByEmail(String Email);
}
