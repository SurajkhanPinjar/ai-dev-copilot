package io.aidevcopilot.rag.retriever;

import io.aidevcopilot.ports.model.SearchResult;

import java.util.List;

public interface Retriever {

    List<SearchResult> retrieve(float[] queryEmbedding, int topK);

}