package io.aidevcopilot.backend.controller;

import io.aidevcopilot.backend.dto.ApiResponse;
import io.aidevcopilot.backend.dto.UploadDocumentResponse;
import io.aidevcopilot.backend.service.DocumentFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentFacade documentFacade;

    @PostMapping(
            value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ApiResponse<UploadDocumentResponse> upload(
            @RequestParam("file") MultipartFile file) {

        UploadDocumentResponse response =
                documentFacade.upload(file);

        return ApiResponse.success(response);
    }

}