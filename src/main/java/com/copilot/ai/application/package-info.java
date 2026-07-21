/**
 * Camada de Aplicação (Hexagonal Architecture — Use Cases).
 *
 * <p>Contém os casos de uso (application services) que orquestram
 * as operações do domínio. Define os ports de entrada (driving ports)
 * que são implementados pelos adapters.</p>
 *
 * <p><b>Futuro:</b></p>
 * <ul>
 *   <li>CreateAgentUseCase — Criação de agentes</li>
 *   <li>ExecuteToolCallingUseCase — Execução de tool calling</li>
 *   <li>ProcessRagQueryUseCase — Pipeline de RAG</li>
 *   <li>OrchestrateWorkflowUseCase — Orquestração de workflows</li>
 * </ul>
 */
package com.copilot.ai.application;
