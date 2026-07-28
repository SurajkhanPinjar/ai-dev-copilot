package io.aidevcopilot.rag.vectorstore.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(RagVectorProperties.class)
public class PgVectorConfiguration {

    private final RagVectorProperties properties;

    @PostConstruct
    public void initialize() {

        log.info("Initializing PGVector Configuration");

        log.info("Embedding dimensions: {}", properties.getDimensions());
    }

}