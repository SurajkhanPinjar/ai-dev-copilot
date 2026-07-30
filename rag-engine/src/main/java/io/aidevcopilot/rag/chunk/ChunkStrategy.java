package io.aidevcopilot.rag.chunk;

import io.aidevcopilot.ports.model.Document;
import io.aidevcopilot.rag.model.DocumentChunk;

import java.util.List;

public interface ChunkStrategy {

    List<DocumentChunk> chunk(Document document, String content);

}