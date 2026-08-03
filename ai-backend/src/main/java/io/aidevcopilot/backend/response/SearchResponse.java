package io.aidevcopilot.backend.response;

import lombok.Builder;

import java.util.List;

@Builder
public record SearchResponse(

        List<SearchChunkResponse> chunks

) {
}