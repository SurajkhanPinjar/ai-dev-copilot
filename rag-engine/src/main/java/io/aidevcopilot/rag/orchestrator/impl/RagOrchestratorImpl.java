package io.aidevcopilot.rag.orchestrator.impl;

import io.aidevcopilot.ports.model.SearchRequest;
import io.aidevcopilot.ports.model.SearchResult;
import io.aidevcopilot.ports.orchestrator.RagOrchestrator;
import io.aidevcopilot.rag.orchestrator.QueryOrchestrator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RagOrchestratorImpl implements RagOrchestrator {

    private final QueryOrchestrator queryOrchestrator;

    @Override
    public List<SearchResult> retrieve(SearchRequest request) {

        return queryOrchestrator.search(request);
    }
}