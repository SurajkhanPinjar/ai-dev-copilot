package io.aidevcopilot.backend.service;

import io.aidevcopilot.backend.dto.UploadDocumentResponse;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentFacade {

    UploadDocumentResponse upload(MultipartFile file);

}