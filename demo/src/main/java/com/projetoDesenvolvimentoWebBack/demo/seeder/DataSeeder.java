package com.projetoDesenvolvimentoWebBack.demo.seeder;

import com.projetoDesenvolvimentoWebBack.demo.model.TestType;
import com.projetoDesenvolvimentoWebBack.demo.repository.TestTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


 // DataSeeder — popula a tabela test_types na primeira execução.
@Component
public class DataSeeder implements CommandLineRunner {

    private final TestTypeRepository testTypeRepository;

    public DataSeeder(TestTypeRepository testTypeRepository) {
        this.testTypeRepository = testTypeRepository;
    }

    @Override
    public void run(String... args) {
        if (testTypeRepository.count() > 0) return; // já populado

        testTypeRepository.save(new TestType(
                "REACTION", "Tempo de Reação", "ms",
                TestType.ComparisonStrategy.LOWER_IS_BETTER
        ));

        testTypeRepository.save(new TestType(
                "AIM", "Treino de Mira", "ms",
                TestType.ComparisonStrategy.LOWER_IS_BETTER
        ));

        testTypeRepository.save(new TestType(
                "VISUAL", "Memória Visual", "acertos",
                TestType.ComparisonStrategy.HIGHER_IS_BETTER
        ));

        testTypeRepository.save(new TestType(
                "NUMBERS", "Span de Números", "dígitos",
                TestType.ComparisonStrategy.HIGHER_IS_BETTER
        ));

        System.out.println(">> DataSeeder: 4 tipos de teste criados.");
    }
}

