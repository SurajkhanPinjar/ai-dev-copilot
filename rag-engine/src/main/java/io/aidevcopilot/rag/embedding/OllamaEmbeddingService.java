package io.aidevcopilot.rag.embedding;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.ollama.OllamaEmbeddingModel;
import io.aidevcopilot.ports.model.EmbeddingChunk;
import io.aidevcopilot.rag.model.DocumentChunk;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OllamaEmbeddingService implements EmbeddingService {

    private static final String MODEL_NAME = "nomic-embed-text";

    private final OllamaEmbeddingModel embeddingModel;

    @Override
    public List<EmbeddingChunk> embed(List<DocumentChunk> chunks) {

        List<EmbeddingChunk> embeddingChunks = new ArrayList<>();

        for (DocumentChunk chunk : chunks) {

            Embedding embedding = embeddingModel
                    .embed(TextSegment.from(chunk.getContent()))
                    .content();

            EmbeddingChunk embeddingChunk = EmbeddingChunk.builder()
                    .documentId(chunk.getDocumentId())
                    .pageNumber(chunk.getPageNumber())
                    .chunkIndex(chunk.getChunkIndex())
                    .content(chunk.getContent())
                    .embedding(embedding.vector())
                    .build();

            embeddingChunks.add(embeddingChunk);
        }

        log.info("Generated {} embeddings using {}", embeddingChunks.size(), MODEL_NAME);

        return embeddingChunks;
    }

    @Override
    public float[] embedQuery(String query) {
        Embedding embedding =
                embeddingModel
                        .embed(TextSegment.from(query))
                        .content();
        return embedding.vector();
    }
}