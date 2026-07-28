//package io.aidevcopilot.rag.parser;
//
//import io.aidevcopilot.rag.model.Document;
//import io.aidevcopilot.rag.model.DocumentType;
//import org.junit.jupiter.api.Test;
//
//import java.time.Instant;
//import java.util.UUID;
//
//class PdfParserTest {
//
//    private final PdfParser pdfParser = new PdfParser();
//
//    @Test
//    void shouldParsePdfSuccessfully() {
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
//        String text = pdfParser.parse(document);
//
//        System.out.println(text);
//
//    }
//
//}