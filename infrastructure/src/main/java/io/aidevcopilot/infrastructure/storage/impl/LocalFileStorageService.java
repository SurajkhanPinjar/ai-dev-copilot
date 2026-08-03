package io.aidevcopilot.infrastructure.storage.impl;

import io.aidevcopilot.infrastructure.storage.FileStorageService;
import io.aidevcopilot.ports.model.Document;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class LocalFileStorageService
        implements FileStorageService {

    private static final Path ROOT = Paths.get("uploads");

    @Override
    public Path store(
            Document document,
            MultipartFile file
    ) {

        try {

            Files.createDirectories(ROOT);

            Path target = ROOT.resolve(
                    document.id() + "-" + file.getOriginalFilename());

            Files.copy(
                    file.getInputStream(),
                    target
            );

            return target;

        } catch (IOException e) {

            throw new RuntimeException(e);

        }
    }
}