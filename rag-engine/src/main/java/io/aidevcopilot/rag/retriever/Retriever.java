package io.aidevcopilot.rag.retriever;

import io.aidevcopilot.rag.model.SearchRequest;
import io.aidevcopilot.rag.model.SearchResult;

import java.util.List;

public interface Retriever {

    List<SearchResult> retrieve(SearchRequest request);

}