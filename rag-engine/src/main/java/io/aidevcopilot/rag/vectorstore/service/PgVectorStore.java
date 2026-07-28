//package io.aidevcopilot.rag.vectorstore.service;
//
//import io.aidevcopilot.rag.model.EmbeddingChunk;
//import io.aidevcopilot.rag.vectorstore.VectorStore;
//import io.aidevcopilot.rag.vectorstore.mapper.ChunkEmbeddingMapper;
//import io.aidevcopilot.rag.vectorstore.repository.ChunkEmbeddingRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class PgVectorStore implements VectorStore {
//
//    private final ChunkEmbeddingRepository repository;
//    private final ChunkEmbeddingMapper mapper;
//
//    @Override
//    public void save(EmbeddingChunk chunk) {
//
//        repository.save(mapper.toEntity(chunk));
//
//        log.info("Stored chunk {} for document {}",
//                chunk.getChunkIndex(),
//                chunk.getDocumentId());
//    }
//
//    @Override
//    public void saveAll(List<EmbeddingChunk> chunks) {
//
//        repository.saveAll(
//                chunks.stream()
//                        .map(mapper::toEntity)
//                        .toList());
//
//        log.info("Stored {} chunks", chunks.size());
//    }
//
//    @Override
//    public void deleteByDocumentId(String documentId) {
//
//        // TODO
//    }
//
//    @Override
//    public List<EmbeddingChunk> searchSimilar(float[] embedding, int topK) {
//
//        // TODO
//        return List.of();
//    }
//}