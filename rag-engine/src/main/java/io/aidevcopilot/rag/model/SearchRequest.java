package io.aidevcopilot.rag.model;

public record SearchRequest(

        String query,

        Integer topK,

        Double minScore

) {
}