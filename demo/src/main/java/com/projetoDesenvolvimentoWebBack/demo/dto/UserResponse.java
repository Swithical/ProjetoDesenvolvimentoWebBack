package com.projetoDesenvolvimentoWebBack.demo.dto;

import com.projetoDesenvolvimentoWebBack.demo.model.User;
import java.time.LocalDateTime;

/**
 * Resposta enviada ao frontend após criar/buscar um usuário.
 * Nunca expomos a entidade User diretamente (evita vazar relações JPA).
 */
public class UserResponse {

    private Long id;
    private String username;
    private LocalDateTime createdAt;

    public UserResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.createdAt = user.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}