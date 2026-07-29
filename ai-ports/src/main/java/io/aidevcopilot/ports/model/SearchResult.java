package io.aidevcopilot.ports.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchResult {

    private String documentId;

    private Integer pageNumber;

    private Integer chunkIndex;

    private String content;

    /**
     * Similarity score.
     */
    private Double score;

}