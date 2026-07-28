package io.aidevcopilot.core.task;

import io.aidevcopilot.core.llm.AIChatClient;
import io.aidevcopilot.core.prompt.PromptService;
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