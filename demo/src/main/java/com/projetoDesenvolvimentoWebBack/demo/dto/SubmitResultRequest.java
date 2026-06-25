package com.projetoDesenvolvimentoWebBack.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Corpo da requisição POST /api/results
 * Enviado pelo frontend ao final de cada tentativa de teste.
 */
public class SubmitResultRequest {

    @NotNull(message = "userId é obrigatório")
    private Long userId;

    @NotBlank(message = "testTypeCode é obrigatório (ex: REACTION, AIM, VISUAL, NUMBERS)")
    private String testTypeCode;

    @NotNull(message = "value é obrigatório")
    private Double value;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTestTypeCode() {
        return testTypeCode;
    }

    public void setTestTypeCode(String testTypeCode) {
        this.testTypeCode = testTypeCode;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
