package io.aidevcopilot.rag.reranker;

import io.aidevcopilot.rag.model.SearchResult;

import java.util.List;

public interface Reranker {

    List<SearchResult> rerank(List<SearchResult> searchResults);

}