package io.aidevcopilot.core.service;

import io.aidevcopilot.ports.model.Document;
import org.springframework.web.multipart.MultipartFile;


public interface DocumentService {

    Document createDocument(MultipartFile file);

}