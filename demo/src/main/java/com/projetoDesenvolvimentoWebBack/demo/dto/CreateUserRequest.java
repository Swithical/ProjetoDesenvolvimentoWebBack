package com.projetoDesenvolvimentoWebBack.demo.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * Corpo da requisição POST /api/users
 */
public class CreateUserRequest {

    @NotBlank(message = "username é obrigatório")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
