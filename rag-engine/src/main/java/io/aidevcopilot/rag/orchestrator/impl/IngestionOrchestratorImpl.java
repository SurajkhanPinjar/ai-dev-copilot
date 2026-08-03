package io.aidevcopilot.rag.orchestrator.impl;

import io.aidevcopilot.ports.model.Document;
import io.aidevcopilot.ports.model.EmbeddingChunk;
import io.aidevcopilot.ports.vector.VectorStore;
import io.aidevcopilot.rag.embedding.EmbeddingService;
import io.aidevcopilot.rag.model.DocumentChunk;
import io.aidevcopilot.rag.orchestrator.DocumentOrchestrator;
import io.aidevcopilot.rag.orchestrator.IngestionOrchestrator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
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
    public void ingest(
            Document document,
            Path filePath
    ) {

        log.info("Starting ingestion for document {}", document.id());

        List<DocumentChunk> chunks =
                documentOrchestrator.process(document, filePath);

        log.info("Generated {} chunks", chunks.size());

        List<EmbeddingChunk> embeddingChunks =
                embeddingService.embed(chunks);

        log.info("Generated {} embeddings", embeddingChunks.size());

        vectorStore.saveAll(embeddingChunks);

        log.info("Saved {} embeddings to vector store", embeddingChunks.size());

    }
}