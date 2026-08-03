package io.aidevcopilot.backend.response;

import lombok.Builder;

@Builder
public record SearchChunkResponse(

        String documentId,

        Integer pageNumber,

        Integer chunkIndex,

        String content

) {
}