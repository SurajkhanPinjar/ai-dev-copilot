package io.aidevcopilot.rag.embedding;

import io.aidevcopilot.rag.model.DocumentChunk;
import io.aidevcopilot.rag.model.EmbeddingChunk;
import io.aidevcopilot.rag.model.EmbeddingVector;

import java.util.List;

public interface EmbeddingService {

    List<EmbeddingChunk> embed(List<DocumentChunk> chunks);

    float[] embedQuery(String query);

}