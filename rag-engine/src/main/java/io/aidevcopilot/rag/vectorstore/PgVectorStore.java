package io.aidevcopilot.rag.vectorstore;

import io.aidevcopilot.rag.model.EmbeddingVector;
import io.aidevcopilot.rag.model.SearchRequest;
import io.aidevcopilot.rag.model.SearchResult;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PgVectorStore implements VectorStore {

    @Override
    public void save(List<EmbeddingVector> embeddings) {
        throw new UnsupportedOperationException("PgVector store not implemented yet.");
    }

    @Override
    public List<SearchResult> search(SearchRequest request) {
        throw new UnsupportedOperationException("PgVector search not implemented yet.");
    }

}