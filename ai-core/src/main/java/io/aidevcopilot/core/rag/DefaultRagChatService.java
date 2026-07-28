package io.aidevcopilot.core.rag;

import io.aidevcopilot.core.llm.AIChatClient;
import io.aidevcopilot.core.model.PromptContext;
import io.aidevcopilot.core.prompt.PromptService;
import io.aidevcopilot.rag.model.SearchRequest;
import io.aidevcopilot.rag.model.SearchResult;
import io.aidevcopilot.rag.orchestrator.RagOrchestrator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import io.aidevcopilot.core.task.AITask;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultRagChatService
        implements RagChatService {

    private final RagOrchestrator ragOrchestrator;
    private final PromptService promptService;
    private final AIChatClient aiChatClient;

    @Override
    public String chat(String question) {

        SearchRequest request =
                SearchRequest.builder()
                        .query(question)
                        .topK(5)
                        .build();

        List<SearchResult> results =
                ragOrchestrator.retrieve(request);

        String context =
                results.stream()
                        .map(SearchResult::getContent)
                        .collect(Collectors.joining("\n\n"));

        PromptContext promptContext =
                new PromptContext(
                        AITask.RAG_CHAT,
                        question,
                        context
                );

        String prompt =
                promptService.generatePrompt(promptContext);

        return aiChatClient.chat(prompt);
    }
}