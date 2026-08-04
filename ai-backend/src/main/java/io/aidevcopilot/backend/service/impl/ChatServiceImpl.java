package io.aidevcopilot.backend.service.impl;

import io.aidevcopilot.backend.dto.TaskRequest;
import io.aidevcopilot.backend.dto.TaskResponse;
import io.aidevcopilot.backend.request.SearchRequest;
import io.aidevcopilot.backend.response.SearchChunkResponse;
import io.aidevcopilot.backend.response.SearchResponse;
import io.aidevcopilot.backend.service.ChatService;
import io.aidevcopilot.core.llm.ChatGenerationService;
import io.aidevcopilot.core.model.PromptContext;
import io.aidevcopilot.core.prompt.PromptService;
import io.aidevcopilot.core.task.TaskRouter;
import io.aidevcopilot.ports.model.SearchResult;
import io.aidevcopilot.rag.orchestrator.QueryOrchestrator;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ChatServiceImpl implements ChatService {

    private static final Logger log =
            LoggerFactory.getLogger(ChatServiceImpl.class);

    private final TaskRouter taskRouter;
    private final QueryOrchestrator queryOrchestrator;

    private final PromptService promptService;
    private final ChatGenerationService chatGenerationService;

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

        log.info("Searching for question: {}", request.question());

        io.aidevcopilot.ports.model.SearchRequest searchRequest =
                io.aidevcopilot.ports.model.SearchRequest.builder()
                        .query(request.question())
                        .topK(request.topK())
                        .build();

        // Retrieve relevant chunks
        List<SearchResult> results =
                queryOrchestrator.search(searchRequest);

        log.info("Retrieved {} chunks", results.size());

        // Build context for Prompt
        String context =
                results.stream()
                        .map(SearchResult::getContent)
                        .collect(Collectors.joining("\n\n"));

        // Generate Prompt
        PromptContext promptContext =
                new PromptContext(
                        io.aidevcopilot.core.task.AITask.CHAT,
                        request.question(),
                        context
                );

        String prompt =
                promptService.generatePrompt(promptContext);

        log.debug("Generated Prompt:\n{}", prompt);

        // Generate Answer
        String answer =
                chatGenerationService.generate(prompt);

        log.info("Generated AI answer successfully.");

        // Convert chunks to response DTO
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
                .answer(answer)
                .chunks(chunks)
                .build();
    }
}