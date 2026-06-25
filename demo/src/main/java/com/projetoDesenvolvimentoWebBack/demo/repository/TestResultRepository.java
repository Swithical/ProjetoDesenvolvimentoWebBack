package com.projetoDesenvolvimentoWebBack.demo.repository;

import com.projetoDesenvolvimentoWebBack.demo.model.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestResultRepository extends JpaRepository<TestResult, Long> {

    // Histórico completo de um usuário, mais recente primeiro
    List<TestResult> findByUserIdOrderByCreatedAtDesc(Long userId);

    // Histórico de um usuário filtrado por tipo de teste
    List<TestResult> findByUserIdAndTestType_CodeOrderByCreatedAtDesc(Long userId, String testTypeCode);
}
