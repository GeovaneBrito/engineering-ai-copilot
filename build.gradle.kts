import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    id("org.springframework.boot") version "3.5.16"
    id("io.spring.dependency-management") version "1.1.7"
}

group = project.property("projectGroup") as String
version = project.property("projectVersion") as String

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
}

val springAiVersion: String by project
val langchain4jVersion: String by project
val springDocVersion: String by project
val mapstructVersion: String by project
val lombokMapstructBindingVersion: String by project
val testcontainersVersion: String by project

dependencyManagement {
    imports {
        mavenBom("org.springframework.ai:spring-ai-bom:$springAiVersion")
        mavenBom("dev.langchain4j:langchain4j-bom:$langchain4jVersion")
    }
}

dependencies {
    // ============================================================
    // Spring Boot Core
    // ============================================================
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")

    // ============================================================
    // Spring AI — Preparado para integração futura com LLMs
    // As dependências estão declaradas mas não configuradas.
    // Ativar quando implementar agentes e tool calling.
    // ============================================================
    implementation("org.springframework.ai:spring-ai-starter-model-openai")
    implementation("org.springframework.ai:spring-ai-starter-vector-store-pgvector")

    // ============================================================
    // LangChain4j — Framework alternativo para orquestração de LLMs
    // Preparado para uso com AI Services, Tools e RAG.
    // ============================================================
    implementation("dev.langchain4j:langchain4j")
    implementation("dev.langchain4j:langchain4j-open-ai")
    implementation("dev.langchain4j:langchain4j-embeddings")

    // ============================================================
    // Database
    // ============================================================
    runtimeOnly("org.postgresql:postgresql")
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-database-postgresql")

    // ============================================================
    // Observability — Métricas, Tracing e Monitoramento
    // Pronto para integração com Prometheus, Grafana e Datadog.
    // ============================================================
    implementation("io.micrometer:micrometer-registry-prometheus")
    implementation("io.micrometer:micrometer-tracing-bridge-brave")

    // ============================================================
    // API Documentation — OpenAPI / Swagger
    // ============================================================
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:$springDocVersion")

    // ============================================================
    // Code Generation — Lombok & MapStruct
    // ============================================================
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    implementation("org.mapstruct:mapstruct:$mapstructVersion")
    annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:$lombokMapstructBindingVersion")

    // ============================================================
    // Testing
    // ============================================================
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-testcontainers")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:postgresql")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
    jvmArgs("-XX:+EnableDynamicAgentLoading")
}

tasks.withType<JavaCompile> {
    options.compilerArgs.addAll(listOf(
        "-Amapstruct.defaultComponentModel=spring",
        "-Amapstruct.unmappedTargetPolicy=IGNORE"
    ))
}

tasks.named<BootJar>("bootJar") {
    layered {
        enabled.set(true)
    }
}
