package io.aidevcopilot.rag.retriever;

import io.aidevcopilot.ports.model.SearchResult;
import io.aidevcopilot.ports.vector.VectorStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SimilarityRetriever implements Retriever {

    private final VectorStore vectorStore;

    @Override
    public List<SearchResult> retrieve(
            float[] queryEmbedding,
            int topK) {

        return vectorStore.searchSimilar(
                queryEmbedding,
                topK
        );
    }
}