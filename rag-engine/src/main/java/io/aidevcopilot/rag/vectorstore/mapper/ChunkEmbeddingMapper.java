package io.aidevcopilot.rag.vectorstore.mapper;

import com.pgvector.PGvector;
import io.aidevcopilot.ports.model.SearchResult;
import io.aidevcopilot.rag.model.EmbeddingChunk;
import io.aidevcopilot.rag.vectorstore.entity.ChunkEmbeddingEntity;
import org.springframework.stereotype.Component;

@Component
public class ChunkEmbeddingMapper {

    public ChunkEmbeddingEntity toEntity(EmbeddingChunk chunk) {

        return ChunkEmbeddingEntity.builder()
                .documentId(chunk.getDocumentId())
                .pageNumber(chunk.getPageNumber())
                .chunkIndex(chunk.getChunkIndex())
                .content(chunk.getContent())
                .embedding(new PGvector(chunk.getEmbedding()))
                .build();
    }

    public EmbeddingChunk toModel(ChunkEmbeddingEntity entity) {

        float[] embedding = entity.getEmbedding() != null
                ? entity.getEmbedding().toArray()
                : null;

        return EmbeddingChunk.builder()
                .documentId(entity.getDocumentId())
                .pageNumber(entity.getPageNumber())
                .chunkIndex(entity.getChunkIndex())
                .content(entity.getContent())
                .embedding(embedding)
                .build();
    }

    public SearchResult toSearchResult(ChunkEmbeddingEntity entity) {
        return SearchResult.builder()
                .documentId(entity.getDocumentId())
                .pageNumber(entity.getPageNumber())
                .chunkIndex(entity.getChunkIndex())
                .content(entity.getContent())
                .build();
    }
}