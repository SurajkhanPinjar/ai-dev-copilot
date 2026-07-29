package io.aidevcopilot.rag.orchestrator.impl;

import io.aidevcopilot.ports.model.SearchRequest;
import io.aidevcopilot.ports.model.SearchResult;
import io.aidevcopilot.rag.embedding.EmbeddingService;
import io.aidevcopilot.rag.orchestrator.QueryOrchestrator;
import io.aidevcopilot.rag.retriever.Retriever;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryOrchestratorImpl
        implements QueryOrchestrator {

    private final EmbeddingService embeddingService;
    private final Retriever retriever;

    @Override
    public List<SearchResult> search(SearchRequest request) {

        float[] queryEmbedding =
                embeddingService.embedQuery(request.getQuery());

        return retriever.retrieve(
                queryEmbedding,
                request.getTopK()
        );
    }
}