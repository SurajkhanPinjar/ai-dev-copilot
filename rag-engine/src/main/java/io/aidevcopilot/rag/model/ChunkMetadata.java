package io.aidevcopilot.rag.model;

import java.util.Map;

public record ChunkMetadata(

        Integer page,

        Integer chunkIndex,

        String source,

        Map<String, Object> attributes

) {
}