package io.aidevcopilot.rag.embedding;

import io.aidevcopilot.rag.model.DocumentChunk;
import io.aidevcopilot.rag.model.EmbeddingVector;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OllamaEmbeddingService implements EmbeddingService {

    @Override
    public List<EmbeddingVector> embed(List<DocumentChunk> chunks) {
        throw new UnsupportedOperationException("Ollama embedding not implemented yet.");
    }

}