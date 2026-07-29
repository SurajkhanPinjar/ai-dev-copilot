package io.aidevcopilot.rag.vectorstore;

import io.aidevcopilot.ports.model.SearchResult;
import io.aidevcopilot.rag.model.EmbeddingChunk;
import io.aidevcopilot.rag.util.VectorUtils;
import io.aidevcopilot.rag.vectorstore.mapper.ChunkEmbeddingMapper;
import io.aidevcopilot.rag.vectorstore.repository.ChunkEmbeddingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PgVectorStore implements VectorStore {

    private final ChunkEmbeddingRepository repository;
    private final ChunkEmbeddingMapper mapper;

    @Override
    public void save(EmbeddingChunk chunk) {
        repository.save(mapper.toEntity(chunk));
        log.info(
                "Stored chunk {} for document {}",
                chunk.getChunkIndex(),
                chunk.getDocumentId()
        );
    }

    @Override
    public void saveAll(List<EmbeddingChunk> chunks) {

        if (chunks == null || chunks.isEmpty()) {
            log.warn("No embedding chunks found to store.");
            return;
        }

        repository.saveAll(
                chunks.stream()
                        .map(mapper::toEntity)
                        .toList()
        );

        log.info("Stored {} embedding chunks.", chunks.size());
    }

    @Override
    public void deleteByDocumentId(String documentId) {

        repository.deleteByDocumentId(documentId);

        log.info("Deleted embeddings for document {}", documentId);
    }

    @Override
    public List<SearchResult> searchSimilar(float[] queryEmbedding,
                                            int topK) {

        if (queryEmbedding == null || queryEmbedding.length == 0) {
            log.warn("Query embedding is empty.");
            return List.of();
        }

        if (topK <= 0) {
            throw new IllegalArgumentException("topK must be greater than zero.");
        }

        log.info("Searching top {} similar chunks.", topK);

        String vector = VectorUtils.toPgVector(queryEmbedding);

        List<SearchResult> results =
                repository.searchSimilar(vector, topK)
                        .stream()
                        .map(mapper::toSearchResult)
                        .toList();

        log.info("Retrieved {} similar chunks.", results.size());

        return results;
    }

}