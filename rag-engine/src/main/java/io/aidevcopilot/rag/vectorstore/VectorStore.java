package io.aidevcopilot.rag.vectorstore;

import io.aidevcopilot.rag.model.EmbeddingVector;
import io.aidevcopilot.rag.model.SearchRequest;
import io.aidevcopilot.rag.model.SearchResult;

import java.util.List;

public interface VectorStore {

    void save(List<EmbeddingVector> embeddings);

    List<SearchResult> search(SearchRequest request);

}