package io.aidevcopilot.rag.orchestrator.impl;

import io.aidevcopilot.rag.embedding.EmbeddingService;
import io.aidevcopilot.rag.model.Document;
import io.aidevcopilot.rag.model.DocumentChunk;
import io.aidevcopilot.rag.model.EmbeddingChunk;
import io.aidevcopilot.rag.orchestrator.DocumentOrchestrator;
import io.aidevcopilot.rag.orchestrator.IngestionOrchestrator;
import io.aidevcopilot.rag.vectorstore.VectorStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngestionOrchestratorImpl
        implements IngestionOrchestrator {

    private final DocumentOrchestrator documentOrchestrator;
    private final EmbeddingService embeddingService;
    private final VectorStore vectorStore;

    @Override
    public void ingest(Document document) {

        List<DocumentChunk> chunks =
                documentOrchestrator.process(document);

        List<EmbeddingChunk> embeddings =
                embeddingService.embed(chunks);

        vectorStore.saveAll(embeddings);
    }
}