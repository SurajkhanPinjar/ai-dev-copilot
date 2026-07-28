package io.aidevcopilot.rag.parser;

import io.aidevcopilot.rag.model.DocumentType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ParserFactory {

    private final List<DocumentParser> parsers;

    public DocumentParser getParser(DocumentType documentType) {

        return parsers.stream()
                .filter(parser -> parser.supports(documentType))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "No parser found for document type : " + documentType));

    }

}