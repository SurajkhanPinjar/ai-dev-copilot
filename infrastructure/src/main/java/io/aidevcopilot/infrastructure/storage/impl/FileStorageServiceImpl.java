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
public class FileStorageServiceImpl implements FileStorageService {

    private static final Path UPLOAD_DIR = Paths.get("uploads");

    @Override
    public String store(Document document, MultipartFile file) {

        try {

            Files.createDirectories(UPLOAD_DIR);

            String fileName =
                    document.id() + "-" + file.getOriginalFilename();

            Path destination =
                    UPLOAD_DIR.resolve(fileName);

            file.transferTo(destination);

            return destination.toString();

        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }
}