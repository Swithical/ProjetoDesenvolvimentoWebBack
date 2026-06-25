package com.projetoDesenvolvimentoWebBack.demo.service;

import com.projetoDesenvolvimentoWebBack.demo.model.User;
import com.projetoDesenvolvimentoWebBack.demo.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Cria um novo usuário. Se o username já existir, apenas retorna o
     * usuário existente — simplifica o fluxo "convidado" do frontend,
     * que tenta criar um usuário a cada visita.
     */
    public User createOrGet(String username) {
        return userRepository.findByUsername(username)
                .orElseGet(() -> userRepository.save(new User(username)));
    }

    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado: id=" + id));
    }
}

