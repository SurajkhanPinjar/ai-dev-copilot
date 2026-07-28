package io.aidevcopilot.rag.chunk;

import io.aidevcopilot.rag.model.Document;
import io.aidevcopilot.rag.model.DocumentChunk;

import java.util.List;

public interface ChunkService {

    List<DocumentChunk> chunk(Document document, String content);

}