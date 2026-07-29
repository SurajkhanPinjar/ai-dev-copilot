package io.aidevcopilot.rag.reranker;


import io.aidevcopilot.ports.model.SearchResult;

import java.util.List;

public interface Reranker {

    List<SearchResult> rerank(List<SearchResult> searchResults);

}