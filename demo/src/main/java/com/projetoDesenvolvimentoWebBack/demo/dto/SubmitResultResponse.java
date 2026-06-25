package com.projetoDesenvolvimentoWebBack.demo.dto;

import com.projetoDesenvolvimentoWebBack.demo.model.TestResult;

/**
 * Resposta para POST /api/results
 * Devolve a tentativa salva + se ela bateu o recorde pessoal,
 * para o frontend exibir algo como "Novo recorde!" na tela.
 */
public class SubmitResultResponse {

    private Long id;
    private String testTypeCode;
    private Double value;
    private boolean isNewRecord;

    public SubmitResultResponse(TestResult result, boolean isNewRecord) {
        this.id           = result.getId();
        this.testTypeCode = result.getTestType().getCode();
        this.value        = result.getValue();
        this.isNewRecord  = isNewRecord;
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

    public boolean isNewRecord() {
        return isNewRecord;
    }
}
