package io.aidevcopilot.rag.orchestrator;

import io.aidevcopilot.ports.model.Document;

import java.io.IOException;
import java.nio.file.Path;

public interface IngestionOrchestrator {

    void ingest(
            Document document,
            Path filePath
    );

}