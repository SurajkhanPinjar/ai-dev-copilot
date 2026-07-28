package io.aidevcopilot.rag.model;

public record DocumentChunk(

        String id,

        String documentId,

        String content,

        ChunkMetadata metadata

) {
}