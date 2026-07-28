package io.aidevcopilot.rag.vectorstore.entity;

import com.pgvector.PGvector;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "document_chunks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChunkEmbeddingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String documentId;

    @Column(nullable = false)
    private Integer pageNumber;

    @Column(nullable = false)
    private Integer chunkIndex;

    @Lob
    @Column(nullable = false)
    private String content;

    /**
     * pgvector embedding (768 dimensions)
     * Mapping will be completed in PgVectorConfiguration.
     */
    @Column(name = "embedding", columnDefinition = "vector(768)", nullable = false)
    private PGvector embedding;

    @Column(nullable = false)
    private LocalDateTime createdAt;
}