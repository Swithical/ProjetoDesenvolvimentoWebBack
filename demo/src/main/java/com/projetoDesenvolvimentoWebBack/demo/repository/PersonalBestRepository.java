package com.projetoDesenvolvimentoWebBack.demo.repository;

import com.projetoDesenvolvimentoWebBack.demo.model.PersonalBest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonalBestRepository extends JpaRepository<PersonalBest, Long> {

    List<PersonalBest> findByUserId(Long userId);

    Optional<PersonalBest> findByUserIdAndTestType_Code(Long userId, String testTypeCode);
}
