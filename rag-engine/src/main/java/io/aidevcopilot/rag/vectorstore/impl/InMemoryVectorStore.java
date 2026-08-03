package io.aidevcopilot.rag.vectorstore.impl;

import io.aidevcopilot.ports.model.EmbeddingChunk;
import io.aidevcopilot.ports.model.SearchResult;
import io.aidevcopilot.ports.vector.VectorStore;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class InMemoryVectorStore implements VectorStore {

    @Override
    public void save(EmbeddingChunk chunk) {
    }

    @Override
    public void saveAll(List<EmbeddingChunk> chunks) {
    }

    @Override
    public void deleteByDocumentId(String documentId) {
    }

    @Override
    public List<SearchResult> searchSimilar(
            float[] queryEmbedding,
            int topK
    ) {
        return Collections.emptyList();
    }
}