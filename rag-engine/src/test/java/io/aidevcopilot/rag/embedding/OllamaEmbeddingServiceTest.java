//package io.aidevcopilot.rag.embedding;
//
//import io.aidevcopilot.rag.chunk.ChunkStrategy;
//import io.aidevcopilot.rag.chunk.FixedSizeChunkStrategy;
//import io.aidevcopilot.rag.embedding.config.OllamaEmbeddingConfiguration;
//import io.aidevcopilot.rag.model.Document;
//import io.aidevcopilot.rag.model.DocumentChunk;
//import io.aidevcopilot.rag.model.DocumentType;
//import io.aidevcopilot.rag.model.EmbeddingChunk;
//import io.aidevcopilot.rag.parser.PdfParser;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.Instant;
//import java.util.List;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//
//@SpringBootTest(classes = {
//        OllamaEmbeddingConfiguration.class,
//        OllamaEmbeddingService.class,
//        PdfParser.class,
//        FixedSizeChunkStrategy.class
//})
//class OllamaEmbeddingServiceTest {
//
//    @Autowired
//    private PdfParser pdfParser;
//
//    @Autowired
//    private ChunkStrategy chunkStrategy;
//
//    @Autowired
//    private OllamaEmbeddingService embeddingService;
//
//    @Test
//    void shouldGenerateEmbeddingsFromPdf() {
//
//        // Arrange
//        Document document = new Document(
//                UUID.randomUUID().toString(),
//                "Agile.pdf",
//                DocumentType.PDF,
//                "src/test/resources/Agile.pdf",
//                0L,
//                Instant.now()
//        );
//
//        // Step 1: Parse PDF
//        String content = pdfParser.parse(document);
//
//        assertFalse(content.isBlank());
//
//        // Step 2: Chunk Document
//        List<DocumentChunk> chunks = chunkStrategy.chunk(document, content);
//
//        assertFalse(chunks.isEmpty());
//
//        // Step 3: Generate Embeddings
//        List<EmbeddingChunk> embeddingChunks = embeddingService.embed(chunks);
//
//        assertFalse(embeddingChunks.isEmpty());
//
//        // Optional: One embedding per chunk
//        assertEquals(chunks.size(), embeddingChunks.size());
//
//        System.out.println("\n======================================");
//        System.out.println("Document            : " + document.name());
//        System.out.println("Chunks Created      : " + chunks.size());
//        System.out.println("Embeddings Created  : " + embeddingChunks.size());
//        System.out.println("======================================");
//
//        EmbeddingChunk firstChunk = embeddingChunks.get(0);
//
//        System.out.println("Document ID         : " + firstChunk.getDocumentId());
//        System.out.println("Page Number         : " + firstChunk.getPageNumber());
//        System.out.println("Chunk Index         : " + firstChunk.getChunkIndex());
//        System.out.println("Embedding Dimension : " + firstChunk.getEmbedding().length);
//
//        System.out.println("\nFirst 10 Embedding Values:");
//
//        float[] vector = firstChunk.getEmbedding();
//
//        for (int i = 0; i < Math.min(10, vector.length); i++) {
//            System.out.printf("[%d] %.6f%n", i, vector[i]);
//        }
//
//        assertEquals(768, vector.length);
//    }
//}