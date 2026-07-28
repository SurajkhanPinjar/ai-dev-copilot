package io.aidevcopilot.rag.reranker;

import io.aidevcopilot.rag.model.SearchResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CrossEncoderReranker implements Reranker {

    @Override
    public List<SearchResult> rerank(List<SearchResult> searchResults) {
        return searchResults;
    }

}