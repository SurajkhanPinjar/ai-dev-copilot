package io.aidevcopilot.rag.vectorstore;

import io.aidevcopilot.ports.model.SearchResult;
import io.aidevcopilot.rag.model.EmbeddingChunk;

import java.util.List;

public interface VectorStore {

    void save(EmbeddingChunk chunk);

    void saveAll(List<EmbeddingChunk> chunks);

    void deleteByDocumentId(String documentId);

    List<SearchResult> searchSimilar(float[] queryEmbedding,
                                     int topK);

}