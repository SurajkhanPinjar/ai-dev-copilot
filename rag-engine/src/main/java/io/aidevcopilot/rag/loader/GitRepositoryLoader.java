package io.aidevcopilot.rag.loader;

import io.aidevcopilot.ports.model.Document;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

@Component
public class GitRepositoryLoader implements DocumentLoader {

    @Override
    public Document load(Path path) {
        throw new UnsupportedOperationException("Git repository loader not implemented yet.");
    }

}