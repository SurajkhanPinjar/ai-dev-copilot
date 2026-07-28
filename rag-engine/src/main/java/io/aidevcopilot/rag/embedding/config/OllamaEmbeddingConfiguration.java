package io.aidevcopilot.rag.embedding.config;

import dev.langchain4j.model.ollama.OllamaEmbeddingModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OllamaEmbeddingConfiguration {

    @Bean
    public OllamaEmbeddingModel ollamaEmbeddingModel(
            @Value("${ollama.base-url}") String baseUrl,
            @Value("${ollama.embedding-model}") String modelName) {

        return OllamaEmbeddingModel.builder()
                .baseUrl(baseUrl)
                .modelName(modelName)
                .build();
    }
}