package io.aidevcopilot.core.task;

import io.aidevcopilot.core.prompt.PromptService;
import io.aidevcopilot.ports.llm.AIChatClient;
import org.springframework.stereotype.Service;

@Service
public class SpringBootAdviserService extends AbstractAITaskService{

    public SpringBootAdviserService(PromptService promptService,
                          AIChatClient aiChatClient) {
        super(promptService, aiChatClient);
    }

    @Override
    protected AITask supportedTask() {
        return AITask.SPRING_BOOT_ADVISOR;
    }
}
