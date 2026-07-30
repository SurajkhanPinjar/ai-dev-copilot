package io.aidevcopilot.rag.loader;

import io.aidevcopilot.ports.model.Document;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

@Component
public class FileSystemLoader implements DocumentLoader {

    @Override
    public Document load(Path path) {
        throw new UnsupportedOperationException("Filesystem loader not implemented yet.");
    }

}