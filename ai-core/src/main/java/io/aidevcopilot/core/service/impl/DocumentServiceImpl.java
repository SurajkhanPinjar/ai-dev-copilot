package io.aidevcopilot.core.service.impl;

import io.aidevcopilot.core.service.DocumentService;
import io.aidevcopilot.ports.model.DocumentType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.aidevcopilot.ports.model.Document;

import java.time.Instant;
import java.util.UUID;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Override
    public Document createDocument(MultipartFile file) {

        return new Document(
                UUID.randomUUID().toString(),
                file.getOriginalFilename(),
                DocumentType.PDF,
                null,
                file.getSize(),
                Instant.now()
        );

    }

}