package io.aidevcopilot.plugin.dto;

public record SearchRequest(
        String question,
        Integer topK
) {
}