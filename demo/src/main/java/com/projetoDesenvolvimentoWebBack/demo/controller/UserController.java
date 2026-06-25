package com.projetoDesenvolvimentoWebBack.demo.controller;

import com.projetoDesenvolvimentoWebBack.demo.dto.CreateUserRequest;
import com.projetoDesenvolvimentoWebBack.demo.dto.UserResponse;
import com.projetoDesenvolvimentoWebBack.demo.model.User;
import com.projetoDesenvolvimentoWebBack.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Endpoints:
 *   POST /api/users      -> cria (ou retorna existente) um usuário
 *   GET  /api/users/{id} -> busca um usuário por id
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@Valid @RequestBody CreateUserRequest request) {
        User user = userService.createOrGet(request.getUsername());
        return new UserResponse(user);
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Long id) {
        return new UserResponse(userService.getById(id));
    }
}
