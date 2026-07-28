package io.aidevcopilot.rag.orchestrator;

import io.aidevcopilot.rag.model.EmbeddingChunk;
import io.aidevcopilot.rag.model.SearchRequest;
import io.aidevcopilot.rag.model.SearchResult;

import java.util.List;

public interface QueryOrchestrator {

    List<SearchResult> search(SearchRequest request);

}