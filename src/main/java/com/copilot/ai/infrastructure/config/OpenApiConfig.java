package com.copilot.ai.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Configuração do OpenAPI / Swagger.
 *
 * <p>Define metadados da API, servidores e informações de contato.
 * Acessível em: /swagger-ui/index.html</p>
 *
 * @author Engineering AI Copilot Team
 * @since 0.1.0
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Engineering AI Copilot API")
                        .version("0.1.0")
                        .description("Plataforma de AI Engineering para orquestração de agentes, "
                                + "tool calling, RAG, MCP e observabilidade.")
                        .contact(new Contact()
                                .name("Engineering AI Copilot Team")
                                .email("team@copilot.ai"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")))
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Local"),
                        new Server().url("https://api.copilot.ai").description("Production")
                ));
    }
}
