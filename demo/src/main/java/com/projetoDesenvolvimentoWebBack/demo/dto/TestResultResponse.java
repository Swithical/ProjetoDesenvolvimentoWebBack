package com.projetoDesenvolvimentoWebBack.demo.dto;

import com.projetoDesenvolvimentoWebBack.demo.model.TestResult;
import java.time.LocalDateTime;

/**
 * Resposta para GET /api/users/{userId}/results
 * Representa uma tentativa individual no histórico do usuário.
 */
public class TestResultResponse {

    private Long id;
    private String testTypeCode;
    private Double value;
    private LocalDateTime createdAt;

    public TestResultResponse(TestResult result) {
        this.id           = result.getId();
        this.testTypeCode = result.getTestType().getCode();
        this.value         = result.getValue();
        this.createdAt     = result.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public String getTestTypeCode() {
        return testTypeCode;
    }

    public Double getValue() {
        return value;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

