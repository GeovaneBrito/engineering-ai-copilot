-- ============================================================
-- Engineering AI Copilot — Migration V1: Schema Inicial
-- ============================================================

-- Habilitar extensão pgvector para busca semântica
-- Será utilizada pelo módulo RAG para armazenar embeddings
CREATE EXTENSION IF NOT EXISTS vector;

-- Habilitar extensão uuid-ossp para geração de UUIDs
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- ============================================================
-- Tabela: agents (Futuro)
-- Armazena a definição dos agentes de IA
-- ============================================================
-- CREATE TABLE agents (
--     id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
--     name VARCHAR(255) NOT NULL UNIQUE,
--     description TEXT,
--     model VARCHAR(100) NOT NULL,
--     temperature DECIMAL(3,2) DEFAULT 0.7,
--     system_prompt TEXT,
--     active BOOLEAN DEFAULT TRUE,
--     created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
--     updated_at TIMESTAMP WITH TIME ZONE DEFAULT NOW()
-- );

-- ============================================================
-- Tabela: conversations (Futuro)
-- Armazena o histórico de conversações
-- ============================================================
-- CREATE TABLE conversations (
--     id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
--     agent_id UUID REFERENCES agents(id),
--     title VARCHAR(500),
--     status VARCHAR(50) DEFAULT 'ACTIVE',
--     created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
--     updated_at TIMESTAMP WITH TIME ZONE DEFAULT NOW()
-- );

-- ============================================================
-- Tabela: embeddings (Futuro)
-- Armazena embeddings para busca semântica (RAG)
-- Utiliza o tipo vector do pgvector
-- ============================================================
-- CREATE TABLE embeddings (
--     id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
--     content TEXT NOT NULL,
--     metadata JSONB,
--     embedding vector(1536),  -- Dimensão do OpenAI text-embedding-3-small
--     created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW()
-- );
--
-- CREATE INDEX idx_embeddings_vector ON embeddings
--     USING ivfflat (embedding vector_cosine_ops)
--     WITH (lists = 100);

-- Schema inicial criado com sucesso.
-- As tabelas acima estão comentadas e serão ativadas
-- conforme o roadmap de implementação.
