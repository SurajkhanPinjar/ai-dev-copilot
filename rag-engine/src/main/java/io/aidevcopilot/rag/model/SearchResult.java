package io.aidevcopilot.rag.model;

public record SearchResult(

        DocumentChunk chunk,

        Double score

) {
}