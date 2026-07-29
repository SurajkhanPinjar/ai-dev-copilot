package io.aidevcopilot.ports.orchestrator;


import io.aidevcopilot.ports.model.SearchRequest;
import io.aidevcopilot.ports.model.SearchResult;

import java.util.List;

public interface RagOrchestrator {

    List<SearchResult> retrieve(SearchRequest request);

}