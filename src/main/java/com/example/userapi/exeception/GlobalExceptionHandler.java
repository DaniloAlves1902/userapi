package com.example.userapi.exeception;

import com.example.userapi.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Classe que centraliza o tratamento de exceções na aplicação.
 *
 * Utiliza {@link ControllerAdvice} para interceptar exceções lançadas
 * e retornar respostas padronizadas com códigos HTTP e mensagens de erro.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Trata exceções genéricas que não possuem tratamento específico.
     * Retorna status HTTP 500 (Internal Server Error).
     *
     * @param ex exceção capturada
     * @return ResponseEntity com objeto ApiError contendo status 500 e mensagem da exceção
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> globalHandlerException(Exception ex) {
        ApiError error = new ApiError(500, ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    /**
     * Trata exceções do tipo {@link DuplicateEmailException}.
     * Retorna status HTTP 400 (Bad Request).
     *
     * @param ex exceção capturada
     * @return ResponseEntity com objeto ApiError contendo status 400 e mensagem da exceção
     */
    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<ApiError> handlerDuplicateEmail(DuplicateEmailException ex) {
        ApiError error = new ApiError(400, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    /**
     * Trata exceções do tipo {@link DuplicateUsernameException}.
     * Retorna status HTTP 400 (Bad Request).
     *
     * @param ex exceção capturada
     * @return ResponseEntity com objeto ApiError contendo status 400 e mensagem da exceção
     */
    @ExceptionHandler(DuplicateUsernameException.class)
    public ResponseEntity<ApiError> handlerDuplicateUsername(DuplicateUsernameException ex) {
        ApiError error = new ApiError(400, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    /**
     * Trata exceções do tipo {@link ResourceNotFoundException}.
     * Retorna status HTTP 404 (Not Found).
     *
     * @param ex exceção capturada
     * @return ResponseEntity com objeto ApiError contendo status 404 e mensagem da exceção
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handlerResourceNotFound(ResourceNotFoundException ex) {
        ApiError error = new ApiError(404, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
