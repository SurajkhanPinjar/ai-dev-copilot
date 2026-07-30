package io.aidevcopilot.rag.chunk;

import io.aidevcopilot.ports.model.Document;
import io.aidevcopilot.rag.model.DocumentChunk;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SemanticChunkStrategy implements ChunkStrategy {

    @Override
    public List<DocumentChunk> chunk(Document document, String content) {
        throw new UnsupportedOperationException("Semantic chunking not implemented yet.");
    }

}