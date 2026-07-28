package io.aidevcopilot.rag.vectorstore.repository;

import io.aidevcopilot.rag.vectorstore.entity.ChunkEmbeddingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ChunkEmbeddingRepository
        extends JpaRepository<ChunkEmbeddingEntity, UUID> {

    void deleteByDocumentId(String documentId);

    @Query(value = """
            SELECT *
            FROM document_chunks
            ORDER BY embedding <=> CAST(:embedding AS vector)
            LIMIT :topK
            """, nativeQuery = true)
    List<ChunkEmbeddingEntity> searchSimilar(
            @Param("embedding") String embedding,
            @Param("topK") int topK
    );

}