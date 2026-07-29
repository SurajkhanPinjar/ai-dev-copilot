package io.aidevcopilot.core.task;

import io.aidevcopilot.core.prompt.PromptService;
import io.aidevcopilot.ports.llm.AIChatClient;
import org.springframework.stereotype.Service;

@Service
public class TestGenerationService extends AbstractAITaskService {

    public TestGenerationService(PromptService promptService,
                                 AIChatClient aiChatClient) {
        super(promptService, aiChatClient);
    }

    @Override
    protected AITask supportedTask() {
        return AITask.GENERATE_TESTS;
    }
}