package io.aidevcopilot.rag.parser;

import io.aidevcopilot.rag.model.Document;
import io.aidevcopilot.rag.model.DocumentType;
import org.springframework.stereotype.Component;

@Component
public class MarkdownParser implements DocumentParser {

    @Override
    public boolean supports(DocumentType documentType) {
        return DocumentType.MARKDOWN == documentType;
    }

    @Override
    public String parse(Document document) {
        throw new UnsupportedOperationException("Markdown parser not implemented yet.");
    }

}