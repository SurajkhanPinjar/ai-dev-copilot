package io.aidevcopilot.backend.service.impl;

import io.aidevcopilot.backend.dto.TaskRequest;
import io.aidevcopilot.backend.dto.TaskResponse;
import io.aidevcopilot.backend.request.SearchRequest;
import io.aidevcopilot.backend.response.SearchChunkResponse;
import io.aidevcopilot.backend.response.SearchResponse;
import io.aidevcopilot.backend.service.ChatService;
import io.aidevcopilot.core.model.PromptContext;
import io.aidevcopilot.core.task.TaskRouter;
import io.aidevcopilot.ports.model.SearchResult;
import io.aidevcopilot.rag.orchestrator.QueryOrchestrator;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatServiceImpl implements ChatService {

    private static final Logger log =
            LoggerFactory.getLogger(ChatServiceImpl.class);

    private final TaskRouter taskRouter;
    private final QueryOrchestrator queryOrchestrator;

    @Override
    public TaskResponse execute(TaskRequest request) {

        log.info("Processing AI task: {}", request.task());

        PromptContext context = new PromptContext(
                request.task(),
                request.input(),
                null
        );

        String response = taskRouter.execute(context);

        log.info("AI task processed successfully");

        return new TaskResponse(response);
    }

    @Override
    public SearchResponse search(SearchRequest request) {

        io.aidevcopilot.ports.model.SearchRequest searchRequest =
                io.aidevcopilot.ports.model.SearchRequest.builder()
                        .query(request.question())
                        .topK(request.topK())
                        .build();

        List<SearchResult> results =
                queryOrchestrator.search(searchRequest);

        List<SearchChunkResponse> chunks =
                results.stream()
                        .map(result ->
                                SearchChunkResponse.builder()
                                        .documentId(result.getDocumentId())
                                        .pageNumber(result.getPageNumber())
                                        .chunkIndex(result.getChunkIndex())
                                        .content(result.getContent())
                                        .build()
                        )
                        .toList();

        return SearchResponse.builder()
                .chunks(chunks)
                .build();
    }
}