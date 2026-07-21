# ============================================================
# Engineering AI Copilot — Multi-Stage Dockerfile
# Stage 1: Build com Gradle
# Stage 2: Runtime com JRE 21 slim
# ============================================================

# --- Stage 1: Build ---
FROM eclipse-temurin:21-jdk-jammy AS builder

WORKDIR /app

# Copiar arquivos do Gradle para cache de dependências
COPY gradle/ gradle/
COPY gradlew build.gradle.kts settings.gradle.kts gradle.properties ./

# Download de dependências (cached layer)
RUN chmod +x gradlew && ./gradlew dependencies --no-daemon

# Copiar código-fonte
COPY src/ src/

# Build da aplicação
RUN ./gradlew bootJar --no-daemon -x test

# --- Stage 2: Runtime ---
FROM eclipse-temurin:21-jre-jammy AS runtime

# Metadados
LABEL maintainer="Engineering AI Copilot Team"
LABEL description="Engineering AI Copilot — AI Engineering Platform"
LABEL version="0.1.0"

# Criar usuário não-root para segurança
RUN groupadd --system appgroup && useradd --system --gid appgroup appuser

WORKDIR /app

# Copiar JAR do estágio de build
COPY --from=builder /app/build/libs/*.jar app.jar

# Permissões
RUN chown -R appuser:appgroup /app
USER appuser

# Expor porta da aplicação
EXPOSE 8080

# Health check
HEALTHCHECK --interval=30s --timeout=10s --retries=3 --start-period=40s \
  CMD curl -f http://localhost:8080/actuator/health || exit 1

# Entrypoint com flags de performance
ENTRYPOINT ["java", \
  "-XX:+UseZGC", \
  "-XX:+ZGenerational", \
  "-XX:MaxRAMPercentage=75.0", \
  "-Djava.security.egd=file:/dev/./urandom", \
  "-jar", "app.jar"]
