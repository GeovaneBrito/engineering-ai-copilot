package com.copilot.ai.domain.exception;

/**
 * Exceção base para erros de negócio do domínio.
 *
 * <p>Todas as exceções de regra de negócio devem estender esta classe.
 * A camada de adapter (controller) converte esta exceção em HTTP 422.</p>
 *
 * @author Engineering AI Copilot Team
 * @since 0.1.0
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
