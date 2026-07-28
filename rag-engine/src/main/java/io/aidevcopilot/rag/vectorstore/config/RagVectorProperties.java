package io.aidevcopilot.rag.vectorstore.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "rag.vector")
public class RagVectorProperties {

    /**
     * Embedding vector dimensions.
     * Example: nomic-embed-text -> 768
     */
    private int dimensions;
}