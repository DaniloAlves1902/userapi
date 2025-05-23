package com.example.userapi.dto;

import java.time.LocalDateTime;

/**
 * Representa um objeto de erro de API que encapsula
 * informações sobre falhas em requisições HTTP, como status, mensagem e timestamp.
 */
public class ApiError {

    /**
     * Código do status HTTP relacionado ao erro (ex: 404, 500).
     */
    private Integer status;

    /**
     * Mensagem descritiva do erro ocorrido.
     */
    private String message;

    /**
     * Data e hora em que o erro ocorreu.
     */
    private LocalDateTime timestamp;

    /**
     * Construtor que inicializa um novo erro de API
     * definindo o código de status, mensagem e o timestamp atual.
     *
     * @param status  código do status HTTP
     * @param message mensagem descritiva do erro
     */
    public ApiError(Integer status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    /**
     * Retorna a mensagem descritiva do erro.
     *
     * @return mensagem do erro
     */
    public String getMessage() {
        return message;
    }

    /**
     * Define a mensagem descritiva do erro.
     *
     * @param message nova mensagem do erro
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Retorna o código do status HTTP do erro.
     *
     * @return código do status HTTP
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Define o código do status HTTP do erro.
     *
     * @param status novo código do status HTTP
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Retorna a data e hora em que o erro ocorreu.
     *
     * @return timestamp do erro
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Define a data e hora do erro.
     *
     * @param timestamp nova data e hora do erro
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
