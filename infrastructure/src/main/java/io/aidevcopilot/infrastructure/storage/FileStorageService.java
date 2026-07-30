package io.aidevcopilot.infrastructure.storage;

import io.aidevcopilot.ports.model.Document;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    String store(Document document, MultipartFile file);

}