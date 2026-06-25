package com.projetoDesenvolvimentoWebBack.demo.repository;

import com.projetoDesenvolvimentoWebBack.demo.model.TestType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestTypeRepository extends JpaRepository<TestType, Long> {

    Optional<TestType> findByCode(String code);
}
