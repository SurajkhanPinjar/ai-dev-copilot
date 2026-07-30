package io.aidevcopilot.backend.service.impl;

import io.aidevcopilot.backend.dto.UploadDocumentResponse;
import io.aidevcopilot.backend.service.DocumentFacade;
import io.aidevcopilot.core.service.DocumentService;
import io.aidevcopilot.ports.orchestrator.RagOrchestrator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.aidevcopilot.ports.model.Document;

@Service
@RequiredArgsConstructor
public class DocumentFacadeImpl implements DocumentFacade {

    private final DocumentService documentService;

    private final RagOrchestrator ragOrchestrator;

    @Override
    public UploadDocumentResponse upload(MultipartFile file) {

        Document document =
                documentService.createDocument(file);

        ragOrchestrator.indexDocument(document, file);

        return UploadDocumentResponse.builder()
                .documentId(document.id())
                .fileName(document.name())
                .status("UPLOADED")
                .build();
    }
}