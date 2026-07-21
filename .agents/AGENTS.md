# Diretrizes de Desenvolvimento — Engineering AI Copilot

## Arquitetura & Padrões
- **Hexagonal**: Regras de negócio em `domain`, orquestração em `application`, integrações em `adapter`.
- **Java 21**: Utilize Records, Pattern Matching, Sealed Interfaces e Virtual Threads.
- **Spring AI / LangChain4j**: Centralize chamadas de LLM em `adapter/out/ai` implementando Ports de `application`.

## Regras de Código
- Imutabilidade em Domain Models (Records ou classes imutáveis).
- Mapeamento explícito de DTOs <-> Entities via MapStruct.
- Validação estrita de entrada via Jakarta Validation + Guardrails em chamadas LLM.
