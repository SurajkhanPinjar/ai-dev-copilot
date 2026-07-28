//package io.aidevcopilot.rag.chunk;
//
//import io.aidevcopilot.rag.model.Document;
//import io.aidevcopilot.rag.model.DocumentChunk;
//import io.aidevcopilot.rag.model.DocumentType;
//import org.junit.jupiter.api.Test;
//
//import java.time.Instant;
//import java.util.List;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class FixedSizeChunkStrategyTest {
//
//    private final FixedSizeChunkStrategy strategy =
//            new FixedSizeChunkStrategy();
//
//    @Test
//    void shouldSplitContentIntoChunks() {
//
//        String content = "A".repeat(1200);
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
//        List<DocumentChunk> chunks = strategy.chunk(document, content);
//
//        System.out.println("=======================================");
//        System.out.println("Document     : " + document.name());
//        System.out.println("Total Chunks : " + chunks.size());
//        System.out.println("=======================================\n");
//
//        for (int i = 0; i < chunks.size(); i++) {
//
//            DocumentChunk chunk = chunks.get(i);
//
//            System.out.println("Chunk #" + i);
//            System.out.println("Document Id : " + chunk.getDocumentId());
//            System.out.println("Page Number : " + chunk.getPageNumber());
//            System.out.println("Chunk Index : " + chunk.getChunkIndex());
//            System.out.println("Length      : " + chunk.getContent().length());
//
//            System.out.println("Preview     : "
//                    + chunk.getContent().substring(0,
//                    Math.min(100, chunk.getContent().length())));
//
//            System.out.println("---------------------------------------");
//        }
//
//        assertEquals(3, chunks.size());
//
//        assertEquals(500, chunks.get(0).getContent().length());
//        assertEquals(500, chunks.get(1).getContent().length());
//        assertEquals(400, chunks.get(2).getContent().length());
//    }
//}