package io.aidevcopilot.infrastructure.storage;

import io.aidevcopilot.ports.model.Document;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface FileStorageService {

    Path store(Document document, MultipartFile file);

}