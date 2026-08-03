package io.aidevcopilot.ports.vector;

import io.aidevcopilot.ports.model.EmbeddingChunk;
import io.aidevcopilot.ports.model.SearchResult;

import java.util.List;

public interface VectorStore {

    void save(EmbeddingChunk chunk);

    void saveAll(List<EmbeddingChunk> chunks);

    void deleteByDocumentId(String documentId);

    List<SearchResult> searchSimilar(float[] queryEmbedding,
                                     int topK);

}