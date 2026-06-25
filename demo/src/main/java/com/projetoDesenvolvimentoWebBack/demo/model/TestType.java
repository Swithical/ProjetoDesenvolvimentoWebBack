package com.projetoDesenvolvimentoWebBack.demo.model;

import jakarta.persistence.*;

/**
 * TestType — tabela de domínio com os tipos de teste disponíveis.
 *
 * Cada linha corresponde a um dos quatro testes do frontend:
 *  REACTION, SEQUENCE, VISUAL, NUMBERS
 *
 * O campo comparisonStrategy define como decidir se um novo resultado
 * é "melhor" que o recorde atual:
 *  - LOWER_IS_BETTER  → tempo de reação (menos ms é melhor)
 *  - HIGHER_IS_BETTER → sequência, visual e números (mais é melhor)
 */
@Entity
@Table(name = "test_types")
public class TestType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Código usado pelo frontend para identificar o teste. */
    @Column(nullable = false, unique = true)
    private String code;

    /** Nome legível, exibido em relatórios/telas administrativas. */
    @Column(nullable = false)
    private String name;

    /** Unidade do valor (ms, nivel, acertos, digitos). */
    private String unit;

    @Enumerated(EnumType.STRING)
    @Column(name = "comparison_strategy", nullable = false)
    private ComparisonStrategy comparisonStrategy;

    public enum ComparisonStrategy {
        LOWER_IS_BETTER,
        HIGHER_IS_BETTER
    }

    public TestType() {
    }

    public TestType(String code, String name, String unit, ComparisonStrategy comparisonStrategy) {
        this.code = code;
        this.name = name;
        this.unit = unit;
        this.comparisonStrategy = comparisonStrategy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public ComparisonStrategy getComparisonStrategy() {
        return comparisonStrategy;
    }

    public void setComparisonStrategy(ComparisonStrategy comparisonStrategy) {
        this.comparisonStrategy = comparisonStrategy;
    }
}