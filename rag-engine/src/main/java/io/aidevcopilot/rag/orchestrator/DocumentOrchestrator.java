package io.aidevcopilot.rag.orchestrator;

import io.aidevcopilot.rag.model.Document;
import io.aidevcopilot.rag.model.DocumentChunk;

import java.util.List;

public interface DocumentOrchestrator {

    List<DocumentChunk> process(Document document);

}