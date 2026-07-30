package io.aidevcopilot.ports.orchestrator;


import io.aidevcopilot.ports.model.Document;
import io.aidevcopilot.ports.model.SearchRequest;
import io.aidevcopilot.ports.model.SearchResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RagOrchestrator {

    List<SearchResult> retrieve(SearchRequest request);

    void indexDocument(
            Document document,
            MultipartFile file
    );

}