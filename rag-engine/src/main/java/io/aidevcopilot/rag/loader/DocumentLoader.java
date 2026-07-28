package io.aidevcopilot.rag.loader;

import io.aidevcopilot.rag.model.Document;

import java.nio.file.Path;

public interface DocumentLoader {

    Document load(Path path);

}