package io.aidevcopilot.rag.orchestrator;

import io.aidevcopilot.ports.model.Document;
import io.aidevcopilot.rag.model.DocumentChunk;

import java.nio.file.Path;
import java.util.List;

public interface DocumentOrchestrator {

    List<DocumentChunk> process(
            Document document,
            Path filePath
    );

}