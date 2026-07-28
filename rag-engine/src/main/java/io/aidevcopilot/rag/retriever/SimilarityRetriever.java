package io.aidevcopilot.rag.retriever;

import io.aidevcopilot.rag.model.SearchRequest;
import io.aidevcopilot.rag.model.SearchResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SimilarityRetriever implements Retriever {

    @Override
    public List<SearchResult> retrieve(SearchRequest request) {
        throw new UnsupportedOperationException("Similarity retrieval not implemented yet.");
    }

}