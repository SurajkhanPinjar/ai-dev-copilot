package io.aidevcopilot.rag.orchestrator.impl;

import io.aidevcopilot.ports.model.Document;
import io.aidevcopilot.rag.chunk.ChunkService;
import io.aidevcopilot.rag.model.DocumentChunk;
import io.aidevcopilot.rag.orchestrator.DocumentOrchestrator;
import io.aidevcopilot.rag.parser.DocumentParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentOrchestratorImpl implements DocumentOrchestrator {

    private final DocumentParser parser;
    private final ChunkService chunkService;

    @Override
    public List<DocumentChunk> process(Document document) {

        String content = parser.parse(document);

        return chunkService.chunk(
                document,
                content
        );
    }
}