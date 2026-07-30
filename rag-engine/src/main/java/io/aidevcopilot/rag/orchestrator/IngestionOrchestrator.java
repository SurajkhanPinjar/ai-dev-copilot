package io.aidevcopilot.rag.orchestrator;


import io.aidevcopilot.ports.model.Document;

public interface IngestionOrchestrator {

    void ingest(Document document);

}