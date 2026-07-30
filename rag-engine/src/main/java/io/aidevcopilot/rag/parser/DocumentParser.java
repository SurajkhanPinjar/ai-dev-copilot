package io.aidevcopilot.rag.parser;

import io.aidevcopilot.ports.model.Document;
import io.aidevcopilot.rag.model.DocumentType;

public interface DocumentParser {

    boolean supports(DocumentType documentType);

    String parse(Document document);

}