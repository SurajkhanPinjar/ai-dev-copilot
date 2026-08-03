package io.aidevcopilot.rag.embedding;

import io.aidevcopilot.ports.model.EmbeddingChunk;
import io.aidevcopilot.rag.model.DocumentChunk;

import java.util.List;

public interface EmbeddingService {

    List<EmbeddingChunk> embed(List<DocumentChunk> chunks);

    float[] embedQuery(String query);

}