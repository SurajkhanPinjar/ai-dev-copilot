package io.aidevcopilot.rag.embedding;

import io.aidevcopilot.rag.model.DocumentChunk;
import io.aidevcopilot.rag.model.EmbeddingChunk;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HuggingFaceEmbeddingService implements EmbeddingService {

    @Override
    public List<EmbeddingChunk> embed(List<DocumentChunk> chunks) {
        throw new UnsupportedOperationException(
                "Hugging Face document embedding is not implemented yet."
        );
    }

    @Override
    public float[] embedQuery(String query) {
        throw new UnsupportedOperationException(
                "Hugging Face query embedding is not implemented yet."
        );
    }
}