package com.projetoDesenvolvimentoWebBack.demo.service;


import jakarta.transaction.Transactional;
import com.projetoDesenvolvimentoWebBack.demo.model.PersonalBest;
import com.projetoDesenvolvimentoWebBack.demo.model.TestResult;
import com.projetoDesenvolvimentoWebBack.demo.model.User;
import com.projetoDesenvolvimentoWebBack.demo.model.TestType;
import com.projetoDesenvolvimentoWebBack.demo.repository.PersonalBestRepository;
import com.projetoDesenvolvimentoWebBack.demo.repository.TestResultRepository;
import com.projetoDesenvolvimentoWebBack.demo.repository.TestTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TestResultService — núcleo da regra de negócio do app.
 *
 * Toda vez que o frontend envia um resultado de teste:
 *  1) Salva a tentativa em TestResult (histórico completo, nunca apagado)
 *  2) Compara com o PersonalBest atual do usuário naquele teste
 *  3) Se for melhor (considerando a estratégia LOWER/HIGHER_IS_BETTER
 *     definida em TestType), atualiza ou cria o PersonalBest
 */
@Service
public class TestResultService {

    private final TestResultRepository testResultRepository;
    private final PersonalBestRepository personalBestRepository;
    private final TestTypeRepository testTypeRepository;
    private final UserService userService;

    public TestResultService(
            TestResultRepository testResultRepository,
            PersonalBestRepository personalBestRepository,
            TestTypeRepository testTypeRepository,
            UserService userService
    ) {
        this.testResultRepository   = testResultRepository;
        this.personalBestRepository = personalBestRepository;
        this.testTypeRepository     = testTypeRepository;
        this.userService            = userService;
    }

    /**
     * Resultado interno do submitResult — não é um DTO de API,
     * apenas um agregado de retorno usado pelo controller para montar
     * a resposta (SubmitResultResponse).
     */
    public record SubmitResult(TestResult testResult, boolean isNewRecord) {}

    /**
     * Registra uma nova tentativa e atualiza o recorde se aplicável.
     *
     * @return a tentativa salva + se ela se tornou o novo recorde pessoal
     */
    @Transactional
    public SubmitResult submitResult(Long userId, String testTypeCode, Double value) {
        User user = userService.getById(userId);

        TestType testType = testTypeRepository.findByCode(testTypeCode)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Tipo de teste desconhecido: " + testTypeCode));

        // 1) Sempre salva a tentativa no histórico
        TestResult saved = testResultRepository.save(new TestResult(user, testType, value));

        // 2) Verifica se bate o recorde atual
        var existingBest = personalBestRepository.findByUserIdAndTestType_Code(userId, testTypeCode);

        boolean isNewRecord = existingBest.isEmpty()
                || isBetter(value, existingBest.get().getBestValue(), testType.getComparisonStrategy());

        if (isNewRecord) {
            PersonalBest pb = existingBest.orElseGet(() -> new PersonalBest(user, testType, value));
            pb.setBestValue(value);
            pb.setAchievedAt(java.time.LocalDateTime.now());
            personalBestRepository.save(pb);
        }

        return new SubmitResult(saved, isNewRecord);
    }

    /** Decide se newValue é melhor que currentBest, de acordo com a estratégia do teste. */
    private boolean isBetter(Double newValue, Double currentBest, TestType.ComparisonStrategy strategy) {
        return strategy == TestType.ComparisonStrategy.LOWER_IS_BETTER
                ? newValue < currentBest
                : newValue > currentBest;
    }

    public List<TestResult> getHistory(Long userId) {
        return testResultRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }

    public List<PersonalBest> getPersonalBests(Long userId) {
        return personalBestRepository.findByUserId(userId);
    }
}

