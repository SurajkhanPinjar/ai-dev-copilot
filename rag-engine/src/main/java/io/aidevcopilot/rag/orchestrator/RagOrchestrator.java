package io.aidevcopilot.rag.orchestrator;

import io.aidevcopilot.rag.model.SearchRequest;
import io.aidevcopilot.rag.model.SearchResult;

import java.util.List;

public interface RagOrchestrator {

    List<SearchResult> retrieve(SearchRequest request);

}