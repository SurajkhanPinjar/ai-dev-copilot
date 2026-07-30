package io.aidevcopilot.rag.parser;

import io.aidevcopilot.ports.model.Document;
import io.aidevcopilot.rag.model.DocumentType;
import io.aidevcopilot.rag.util.PdfUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

@Component
@Primary
public class PdfParser implements DocumentParser {

    @Override
    public boolean supports(DocumentType documentType) {
        return documentType == DocumentType.PDF;
    }

    @Override
    public String parse(Document document) {

        Path pdfPath = Path.of(document.location());

        return PdfUtils.extractText(pdfPath);

    }
}