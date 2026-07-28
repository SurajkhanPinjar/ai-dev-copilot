package io.aidevcopilot.rag.model;

public record EmbeddingVector(

        String chunkId,

        float[] vector,

        EmbeddingMetadata metadata

) {
}