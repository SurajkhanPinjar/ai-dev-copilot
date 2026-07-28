package io.aidevcopilot.rag.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchRequest {

    /**
     * User's natural language query.
     */
    private String query;

    /**
     * Number of chunks to retrieve.
     */
    @Builder.Default
    private Integer topK = 5;

}