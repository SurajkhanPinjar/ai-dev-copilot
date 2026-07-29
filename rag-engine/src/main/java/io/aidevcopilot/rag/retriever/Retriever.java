package io.aidevcopilot.rag.retriever;

import io.aidevcopilot.ports.model.SearchResult;
import io.aidevcopilot.rag.model.EmbeddingChunk;

import java.util.List;

public interface Retriever {

    List<SearchResult> retrieve(float[] queryEmbedding, int topK);

}