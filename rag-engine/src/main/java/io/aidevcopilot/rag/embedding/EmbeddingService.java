package io.aidevcopilot.rag.embedding;

import io.aidevcopilot.rag.model.DocumentChunk;
import io.aidevcopilot.rag.model.EmbeddingVector;

import java.util.List;

public interface EmbeddingService {

    List<EmbeddingVector> embed(List<DocumentChunk> chunks);

}