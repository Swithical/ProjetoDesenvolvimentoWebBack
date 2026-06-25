package com.projetoDesenvolvimentoWebBack.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * PersonalBest — recorde atual de um usuário em um tipo de teste.
 *
 * Existe no máximo 1 registro por par (user, testType) — garantido pela
 * uniqueConstraint abaixo. É a tabela que o frontend consulta para
 * preencher o objeto `scores` exibido na Home.
 */
@Entity
@Table(
        name = "personal_bests",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "test_type_id"})
)
public class PersonalBest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_type_id", nullable = false)
    private TestType testType;

    @Column(name = "best_value", nullable = false)
    private Double bestValue;

    @Column(name = "achieved_at", nullable = false)
    private LocalDateTime achievedAt = LocalDateTime.now();

    public PersonalBest() {
    }

    public PersonalBest(User user, TestType testType, Double bestValue) {
        this.user = user;
        this.testType = testType;
        this.bestValue = bestValue;
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

    public Double getBestValue() {
        return bestValue;
    }

    public void setBestValue(Double bestValue) {
        this.bestValue = bestValue;
    }

    public LocalDateTime getAchievedAt() {
        return achievedAt;
    }

    public void setAchievedAt(LocalDateTime achievedAt) {
        this.achievedAt = achievedAt;
    }
}

