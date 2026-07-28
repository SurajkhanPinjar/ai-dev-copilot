package io.aidevcopilot.rag.model;

public record EmbeddingMetadata(

        String provider,

        String model,

        Integer dimensions

) {
}