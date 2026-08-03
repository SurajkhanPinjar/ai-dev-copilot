package io.aidevcopilot.rag.parser;

import io.aidevcopilot.ports.model.DocumentType;

import java.nio.file.Path;

public interface DocumentParser {

    boolean supports(DocumentType type);

    String parse(Path filePath);

}