package com.example.userapi.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceção lançada quando um recurso solicitado não é encontrado no sistema.
 *
 * Ao ser lançada, retorna o status HTTP 404 (Not Found) automaticamente.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Construtor que recebe a mensagem detalhando o motivo da exceção.
     *
     * @param message mensagem explicativa da exceção
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
