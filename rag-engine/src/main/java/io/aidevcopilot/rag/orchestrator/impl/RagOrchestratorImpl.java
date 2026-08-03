package io.aidevcopilot.rag.orchestrator.impl;

import io.aidevcopilot.infrastructure.storage.FileStorageService;
import io.aidevcopilot.ports.model.Document;
import io.aidevcopilot.ports.model.SearchRequest;
import io.aidevcopilot.ports.model.SearchResult;
import io.aidevcopilot.ports.orchestrator.RagOrchestrator;
import io.aidevcopilot.rag.orchestrator.IngestionOrchestrator;
import io.aidevcopilot.rag.orchestrator.QueryOrchestrator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RagOrchestratorImpl
        implements RagOrchestrator {

    private final QueryOrchestrator queryOrchestrator;
    private final FileStorageService storageService;
    private final IngestionOrchestrator ingestionOrchestrator;

    @Override
    public void indexDocument(
            Document document,
            MultipartFile file
    ) {

        Path filePath =
                storageService.store(document, file);

        ingestionOrchestrator.ingest(
                document,
                filePath);
    }

    @Override
    public List<SearchResult> retrieve(SearchRequest request) {
        return queryOrchestrator.search(request);
    }
}