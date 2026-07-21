package com.copilot.ai.adapter.in.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

/**
 * Controller de health check da aplicação.
 *
 * <p>Endpoint simples para verificar se a aplicação está operacional.
 * Complementa o Actuator com informações customizadas.</p>
 *
 * @author Engineering AI Copilot Team
 * @since 0.1.0
 */
@RestController
@RequestMapping("/api/v1")
public class HealthCheckController {

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> health() {
        return ResponseEntity.ok(Map.of(
                "status", "UP",
                "service", "engineering-ai-copilot",
                "version", "0.1.0",
                "timestamp", Instant.now().toString()
        ));
    }
}
