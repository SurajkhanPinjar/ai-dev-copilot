package io.aidevcopilot.rag.parser;

import io.aidevcopilot.ports.model.DocumentType;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

@Component
public class JavaParser implements DocumentParser {

    @Override
    public boolean supports(DocumentType documentType) {
        return DocumentType.JAVA == documentType;
    }

    @Override
    public String parse(Path filePath) {
        throw new UnsupportedOperationException(
                "Java parser not implemented yet."
        );
    }
}