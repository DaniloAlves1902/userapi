package com.example.userapi.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceção lançada quando ocorre uma tentativa de cadastro ou atualização
 * com um nome de usuário (username) que já existe no sistema.
 *
 * Ao ser lançada, retorna o status HTTP 400 (Bad Request) automaticamente.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateUsernameException extends RuntimeException {

    /**
     * Construtor que recebe a mensagem detalhando o motivo da exceção.
     *
     * @param message mensagem explicativa da exceção
     */
    public DuplicateUsernameException(String message) {
        super(message);
    }
}
