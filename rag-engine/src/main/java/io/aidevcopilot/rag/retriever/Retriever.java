package io.aidevcopilot.rag.retriever;

import io.aidevcopilot.rag.model.EmbeddingChunk;
import io.aidevcopilot.rag.model.SearchResult;

import java.util.List;

public interface Retriever {

    List<SearchResult> retrieve(float[] queryEmbedding, int topK);

}