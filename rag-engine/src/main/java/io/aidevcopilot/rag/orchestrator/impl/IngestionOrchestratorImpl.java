package io.aidevcopilot.rag.orchestrator.impl;

import io.aidevcopilot.ports.model.Document;
import io.aidevcopilot.rag.embedding.EmbeddingService;
import io.aidevcopilot.rag.model.DocumentChunk;
import io.aidevcopilot.rag.model.EmbeddingChunk;
import io.aidevcopilot.rag.orchestrator.DocumentOrchestrator;
import io.aidevcopilot.rag.orchestrator.IngestionOrchestrator;
import io.aidevcopilot.rag.vectorstore.VectorStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class IngestionOrchestratorImpl
        implements IngestionOrchestrator {

    private final DocumentOrchestrator documentOrchestrator;
    private final EmbeddingService embeddingService;
    private final VectorStore vectorStore;

    @Override
    public void ingest(Document document) {

        log.info("Starting ingestion for document {}", document.id());

        List<DocumentChunk> chunks =
                documentOrchestrator.process(document);

        List<EmbeddingChunk> embeddingChunks =
                embeddingService.embed(chunks);

        vectorStore.saveAll(embeddingChunks);

        log.info(
                "Successfully ingested document {} with {} chunks",
                document.id(),
                embeddingChunks.size()
        );
    }
}