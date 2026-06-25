package com.projetoDesenvolvimentoWebBack.demo.dto;

import com.projetoDesenvolvimentoWebBack.demo.model.PersonalBest;
import java.time.LocalDateTime;

/**
 * Resposta para GET /api/users/{userId}/personal-bests
 *
 * O frontend recebe uma lista desses objetos e monta o `ScoresMap`
 * (testTypeCode -> bestValue) usado na tela Home.
 */
public class PersonalBestResponse {

    private String testTypeCode;
    private String testTypeName;
    private String unit;
    private Double bestValue;
    private LocalDateTime achievedAt;

    public PersonalBestResponse(PersonalBest pb) {
        this.testTypeCode = pb.getTestType().getCode();
        this.testTypeName = pb.getTestType().getName();
        this.unit         = pb.getTestType().getUnit();
        this.bestValue     = pb.getBestValue();
        this.achievedAt    = pb.getAchievedAt();
    }

    public String getTestTypeCode() {
        return testTypeCode;
    }

    public String getTestTypeName() {
        return testTypeName;
    }

    public String getUnit() {
        return unit;
    }

    public Double getBestValue() {
        return bestValue;
    }

    public LocalDateTime getAchievedAt() {
        return achievedAt;
    }
}

