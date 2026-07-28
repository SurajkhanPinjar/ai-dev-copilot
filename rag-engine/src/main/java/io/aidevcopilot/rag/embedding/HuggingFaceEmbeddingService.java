package io.aidevcopilot.rag.embedding;

import io.aidevcopilot.rag.model.DocumentChunk;
import io.aidevcopilot.rag.model.EmbeddingVector;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HuggingFaceEmbeddingService implements EmbeddingService {

    @Override
    public List<EmbeddingVector> embed(List<DocumentChunk> chunks) {
        throw new UnsupportedOperationException("Hugging Face embedding not implemented yet.");
    }

}