package io.aidevcopilot.rag.orchestrator;

import io.aidevcopilot.ports.model.SearchRequest;
import io.aidevcopilot.ports.model.SearchResult;

import java.util.List;

public interface QueryOrchestrator {

    List<SearchResult> search(SearchRequest request);

}