package io.aidevcopilot.rag.vectorstore;

import io.aidevcopilot.ports.model.EmbeddingChunk;
import io.aidevcopilot.ports.model.SearchResult;
import io.aidevcopilot.ports.vector.VectorStore;
import io.aidevcopilot.rag.util.VectorUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@Primary
@RequiredArgsConstructor
public class PgVectorStore implements VectorStore {

    private final JdbcTemplate jdbcTemplate;

    private static final String INSERT_SQL = """
            INSERT INTO document_chunks
            (
                document_id,
                page_number,
                chunk_index,
                content,
                embedding,
                created_at
            )
            VALUES
            (
                ?, ?, ?, ?, ?::vector, ?
            )
            """;

    private static final String DELETE_SQL = """
            DELETE
            FROM document_chunks
            WHERE document_id = ?
            """;

    private static final String SEARCH_SQL = """
            SELECT
                document_id,
                page_number,
                chunk_index,
                content
            FROM document_chunks
            ORDER BY embedding <=> ?::vector
            LIMIT ?
            """;

    @Override
    public void save(EmbeddingChunk chunk) {

        if (chunk == null) {
            throw new IllegalArgumentException("EmbeddingChunk cannot be null.");
        }

        Timestamp createdAt =
                Timestamp.valueOf(LocalDateTime.now());

        jdbcTemplate.update(
                INSERT_SQL,
                chunk.getDocumentId(),
                chunk.getPageNumber(),
                chunk.getChunkIndex(),
                chunk.getContent(),
                VectorUtils.toPgVector(chunk.getEmbedding()),
                createdAt
        );

        log.info(
                "Stored chunk {} for document {}",
                chunk.getChunkIndex(),
                chunk.getDocumentId()
        );
    }

    @Override
    public void saveAll(List<EmbeddingChunk> chunks) {

        if (chunks == null || chunks.isEmpty()) {
            log.warn("No embedding chunks to store.");
            return;
        }

        chunks.forEach(this::save);

        log.info("Stored {} embedding chunks.", chunks.size());
    }

    @Override
    public void deleteByDocumentId(String documentId) {

        int deleted =
                jdbcTemplate.update(DELETE_SQL, documentId);

        log.info(
                "Deleted {} chunks for document {}",
                deleted,
                documentId
        );
    }

    @Override
    public List<SearchResult> searchSimilar(
            float[] queryEmbedding,
            int topK
    ) {

        if (queryEmbedding == null || queryEmbedding.length == 0) {
            throw new IllegalArgumentException("Query embedding cannot be empty.");
        }

        if (topK <= 0) {
            throw new IllegalArgumentException("topK must be greater than zero.");
        }

        String vector =
                VectorUtils.toPgVector(queryEmbedding);

        List<SearchResult> results =
                jdbcTemplate.query(
                        SEARCH_SQL,
                        (rs, rowNum) -> SearchResult.builder()
                                .documentId(rs.getString("document_id"))
                                .pageNumber(rs.getInt("page_number"))
                                .chunkIndex(rs.getInt("chunk_index"))
                                .content(rs.getString("content"))
                                .build(),
                        vector,
                        topK
                );

        log.info(
                "Retrieved {} similar chunks.",
                results.size()
        );

        return results;
    }
}