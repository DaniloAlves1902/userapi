package com.example.userapi.dto;

import java.time.LocalDateTime;

public class ApiError {
    private Integer status;
    private String message;
    private LocalDateTime timestamp;

    public ApiError(Integer status, String message) {
        this.status = status;
        this.message = message;

        this.timestamp = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
