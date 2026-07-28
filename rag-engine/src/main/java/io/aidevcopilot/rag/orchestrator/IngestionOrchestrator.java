package io.aidevcopilot.rag.orchestrator;

import io.aidevcopilot.rag.model.Document;

public interface IngestionOrchestrator {

    void ingest(Document document);

}