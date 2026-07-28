package io.aidevcopilot.infrastructure.config;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.ollama.OllamaEmbeddingModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OllamaConfig {

    @Bean
    public ChatModel chatModel(OllamaProperties properties) {

        return OllamaChatModel.builder()
                .baseUrl(properties.getBaseUrl())
                .modelName(properties.getChatModel())
                .build();
    }

    @Bean
    public EmbeddingModel embeddingModel(OllamaProperties properties) {

        return OllamaEmbeddingModel.builder()
                .baseUrl(properties.getBaseUrl())
                .modelName(properties.getEmbeddingModel())
                .build();
    }
}