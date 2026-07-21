package com.copilot.ai;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Teste de contexto da aplicação.
 *
 * <p>Verifica que o contexto do Spring Boot inicializa corretamente
 * com todas as configurações e beans.</p>
 */
@SpringBootTest
@ActiveProfiles("local")
class EngineeringAiCopilotApplicationTests {

    @Test
    void contextLoads() {
        // Verifica que o contexto do Spring inicializa sem erros
    }
}
