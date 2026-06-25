package com.projetoDesenvolvimentoWebBack.demo.controller;

import com.projetoDesenvolvimentoWebBack.demo.dto.PersonalBestResponse;
import com.projetoDesenvolvimentoWebBack.demo.dto.SubmitResultRequest;
import com.projetoDesenvolvimentoWebBack.demo.dto.SubmitResultResponse;
import com.projetoDesenvolvimentoWebBack.demo.dto.TestResultResponse;
import com.projetoDesenvolvimentoWebBack.demo.service.TestResultService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Endpoints:
 *   POST /api/results                       -> registra uma tentativa de teste
 *   GET  /api/users/{userId}/results          -> histórico completo do usuário
 *   GET  /api/users/{userId}/personal-bests    -> recordes do usuário
 */
@RestController
@RequestMapping("/api")
public class TestResultController {

    private final TestResultService testResultService;

    public TestResultController(TestResultService testResultService) {
        this.testResultService = testResultService;
    }

    @PostMapping("/results")
    public SubmitResultResponse submit(@Valid @RequestBody SubmitResultRequest request) {
        var result = testResultService.submitResult(
                request.getUserId(),
                request.getTestTypeCode(),
                request.getValue()
        );
        return new SubmitResultResponse(result.testResult(), result.isNewRecord());
    }

    @GetMapping("/users/{userId}/results")
    public List<TestResultResponse> history(@PathVariable Long userId) {
        return testResultService.getHistory(userId).stream()
                .map(TestResultResponse::new)
                .toList();
    }

    @GetMapping("/users/{userId}/personal-bests")
    public List<PersonalBestResponse> personalBests(@PathVariable Long userId) {
        return testResultService.getPersonalBests(userId).stream()
                .map(PersonalBestResponse::new)
                .toList();
    }
}
