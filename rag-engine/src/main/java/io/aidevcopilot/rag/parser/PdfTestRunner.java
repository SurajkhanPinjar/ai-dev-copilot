package io.aidevcopilot.rag.parser;

import io.aidevcopilot.rag.model.Document;
import io.aidevcopilot.rag.model.DocumentType;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PdfTestRunner implements CommandLineRunner {

    private final PdfParser pdfParser;

    @Override
    public void run(String... args) {

        Document document = new Document(
                UUID.randomUUID().toString(),
                "sample.pdf",
                DocumentType.PDF,
                "/Users/surajkhanpinjar/path/to/sample.pdf", // <-- Update with actual path
                0L,
                Instant.now()
        );

        String text = pdfParser.parse(document);

        System.out.println("====================================");
        System.out.println("PDF CONTENT");
        System.out.println("====================================");
        System.out.println(text);
    }
}