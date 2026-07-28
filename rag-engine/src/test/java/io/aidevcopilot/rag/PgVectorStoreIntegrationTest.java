//package io.aidevcopilot.rag;
//
//import io.aidevcopilot.rag.chunk.ChunkStrategy;
//import io.aidevcopilot.rag.embedding.EmbeddingService;
//import io.aidevcopilot.rag.model.Document;
//import io.aidevcopilot.rag.model.DocumentChunk;
//import io.aidevcopilot.rag.model.DocumentType;
//import io.aidevcopilot.rag.model.EmbeddingChunk;
//import io.aidevcopilot.rag.parser.PdfParser;
//import io.aidevcopilot.rag.vectorstore.PgVectorStore;
//import io.aidevcopilot.rag.vectorstore.repository.ChunkEmbeddingRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.time.Instant;
//import java.util.List;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//
//class PgVectorStoreIntegrationTest {
//
//    @Autowired
//    private PdfParser pdfParser;
//
//    @Autowired
//    private ChunkStrategy chunkStrategy;
//
//    @Autowired
//    private EmbeddingService embeddingService;
//
//    @Autowired
//    private PgVectorStore vectorStore;
//
//    @Autowired
//    private ChunkEmbeddingRepository repository;
//
//    @BeforeEach
//    void cleanDatabase() {
//        repository.deleteAll();
//    }
//
//    @Test
//    void shouldStorePdfEmbeddingsInPostgres() {
//
//        Document document = new Document(
//                UUID.randomUUID().toString(),
//                "Agile.pdf",
//                DocumentType.PDF,
//                "src/test/resources/Agile.pdf",
//                0L,
//                Instant.now()
//        );
//
//        String content = pdfParser.parse(document);
//
//        List<DocumentChunk> chunks =
//                chunkStrategy.chunk(document, content);
//
//        List<EmbeddingChunk> embeddings =
//                embeddingService.embed(chunks);
//
//        vectorStore.saveAll(embeddings);
//
//        long count = repository.count();
//
//        System.out.println("--------------------------------------");
//        System.out.println("Chunks      : " + chunks.size());
//        System.out.println("Embeddings  : " + embeddings.size());
//        System.out.println("Database    : " + count);
//        System.out.println("--------------------------------------");
//
//        assertFalse(embeddings.isEmpty());
//
//        assertEquals(
//                embeddings.size(),
//                count
//        );
//    }
//}