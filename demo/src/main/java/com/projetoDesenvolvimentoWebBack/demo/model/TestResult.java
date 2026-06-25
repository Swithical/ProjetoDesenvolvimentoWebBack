package com.projetoDesenvolvimentoWebBack.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * TestResult — registra UMA tentativa de um teste.
 *
 * Exemplos:
 *  - REACTION: value = 215.0 (ms)
 *  - SEQUENCE: value = 7.0   (nível alcançado)
 *  - VISUAL:   value = 9.0   (acertos)
 *  - NUMBERS:  value = 6.0   (dígitos memorizados)
 */
@Entity
@Table(name = "test_results")
public class TestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_type_id", nullable = false)
    private TestType testType;

    @Column(nullable = false)
    private Double value;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public TestResult() {
    }

    public TestResult(User user, TestType testType, Double value) {
        this.user = user;
        this.testType = testType;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TestType getTestType() {
        return testType;
    }

    public void setTestType(TestType testType) {
        this.testType = testType;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

