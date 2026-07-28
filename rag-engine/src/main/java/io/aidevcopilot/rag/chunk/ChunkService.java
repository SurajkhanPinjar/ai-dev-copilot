package io.aidevcopilot.rag.chunk;

import io.aidevcopilot.rag.model.Document;
import io.aidevcopilot.rag.model.DocumentChunk;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChunkService {

    private final ChunkStrategy chunkStrategy;

    public List<DocumentChunk> chunk(Document document, String content) {
        return chunkStrategy.chunk(document, content);
    }

}