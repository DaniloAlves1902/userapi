package com.example.userapi.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceção lançada quando uma tentativa de cadastro ou atualização
 * envolve um e-mail que já está registrado no sistema.
 *
 * Ao ser lançada, retorna automaticamente o status HTTP 400 (Bad Request).
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateEmailException extends RuntimeException {

    /**
     * Construtor que recebe a mensagem descritiva da exceção.
     *
     * @param message mensagem explicando o motivo da exceção
     */
    public DuplicateEmailException(String message) {
        super(message);
    }
}
