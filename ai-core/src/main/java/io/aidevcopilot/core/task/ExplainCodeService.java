package io.aidevcopilot.core.task;

import io.aidevcopilot.core.llm.AIChatClient;
import io.aidevcopilot.core.prompt.PromptService;
import org.springframework.stereotype.Service;

@Service
public class ExplainCodeService extends AbstractAITaskService {

    public ExplainCodeService(PromptService promptService,
                              AIChatClient aiChatClient) {
        super(promptService, aiChatClient);
    }

    @Override
    protected AITask supportedTask() {
        return AITask.EXPLAIN_CODE;
    }
}