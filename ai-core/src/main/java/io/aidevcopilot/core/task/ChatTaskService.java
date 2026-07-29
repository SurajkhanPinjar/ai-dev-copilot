package io.aidevcopilot.core.task;

import io.aidevcopilot.core.model.PromptContext;
import io.aidevcopilot.core.prompt.PromptService;
import io.aidevcopilot.ports.llm.AIChatClient;
import io.aidevcopilot.ports.model.SearchRequest;
import io.aidevcopilot.ports.model.SearchResult;
import io.aidevcopilot.ports.orchestrator.RagOrchestrator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatTaskService extends AbstractAITaskService {

    private final RagOrchestrator ragOrchestrator;

    public ChatTaskService(
            PromptService promptService,
            AIChatClient aiChatClient,
            RagOrchestrator ragOrchestrator
    ) {
        super(promptService, aiChatClient);
        this.ragOrchestrator = ragOrchestrator;
    }

    @Override
    protected AITask supportedTask() {
        return AITask.CHAT;
    }

    @Override
    public String execute(PromptContext context) {

        validate(context);

        SearchRequest request = SearchRequest.builder()
                .query(context.input())
                .topK(5)
                .build();

        List<SearchResult> results =
                ragOrchestrator.retrieve(request);

        String retrievedContext =
                results.stream()
                        .map(SearchResult::getContent)
                        .collect(Collectors.joining("\n\n"));

        PromptContext ragContext =
                new PromptContext(
                        context.task(),
                        context.input(),
                        retrievedContext
                );

        String prompt = promptService.generatePrompt(ragContext);

        return aiChatClient.chat(prompt);
    }
}