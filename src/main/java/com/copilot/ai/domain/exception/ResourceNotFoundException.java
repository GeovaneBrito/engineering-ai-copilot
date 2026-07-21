package com.copilot.ai.domain.exception;

/**
 * Exceção para recurso não encontrado.
 *
 * <p>Lançada quando uma entidade não é encontrada pelo identificador.
 * A camada de adapter converte esta exceção em HTTP 404.</p>
 *
 * @author Engineering AI Copilot Team
 * @since 0.1.0
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String resourceName, Object identifier) {
        super(String.format("%s not found with identifier: %s", resourceName, identifier));
    }
}
