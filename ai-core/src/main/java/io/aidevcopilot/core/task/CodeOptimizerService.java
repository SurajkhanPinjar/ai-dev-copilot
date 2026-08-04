package io.aidevcopilot.core.task;

import io.aidevcopilot.core.prompt.PromptService;
import io.aidevcopilot.ports.llm.AIChatClient;
import org.springframework.stereotype.Service;

@Service
public class CodeOptimizerService extends AbstractAITaskService {

    public CodeOptimizerService(PromptService promptService,
                              AIChatClient aiChatClient) {
        super(promptService, aiChatClient);
    }

    @Override
    protected AITask supportedTask() {
        return AITask.OPTIMIZE_CODE;
    }
}
