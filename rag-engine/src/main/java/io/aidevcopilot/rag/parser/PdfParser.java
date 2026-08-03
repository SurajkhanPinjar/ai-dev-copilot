package io.aidevcopilot.rag.parser;

import io.aidevcopilot.ports.model.DocumentType;
import io.aidevcopilot.rag.parser.DocumentParser;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;

@Component
public class PdfParser
        implements DocumentParser {

    @Override
    public boolean supports(DocumentType type) {

        return type == DocumentType.PDF;

    }

    @Override
    public String parse(Path filePath) {

        try (PDDocument pdf =
                     Loader.loadPDF(filePath.toFile())) {

            PDFTextStripper stripper =
                    new PDFTextStripper();

            return stripper.getText(pdf);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

}