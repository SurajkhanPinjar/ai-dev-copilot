package io.aidevcopilot.rag.parser;

import io.aidevcopilot.ports.model.DocumentType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ParserFactory {

    private final List<DocumentParser> parsers;
    public DocumentParser getParser(
            DocumentType type
    ) {
        return parsers.stream()
                .filter(p -> p.supports(type))
                .findFirst()
                .orElseThrow();
    }

}