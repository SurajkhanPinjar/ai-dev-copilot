package io.aidevcopilot.rag.chunk;

import io.aidevcopilot.rag.model.Document;
import io.aidevcopilot.rag.model.DocumentChunk;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecursiveChunkStrategy implements ChunkStrategy {

    @Override
    public List<DocumentChunk> chunk(Document document, String content) {
        throw new UnsupportedOperationException("Recursive chunking not implemented yet.");
    }

}