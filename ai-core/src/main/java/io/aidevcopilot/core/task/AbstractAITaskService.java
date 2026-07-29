package io.aidevcopilot.core.task;

import io.aidevcopilot.core.model.PromptContext;
import io.aidevcopilot.core.prompt.PromptService;
import io.aidevcopilot.ports.llm.AIChatClient;

public abstract class AbstractAITaskService {

    protected final PromptService promptService;
    protected final AIChatClient aiChatClient;

    protected AbstractAITaskService(
            PromptService promptService,
            AIChatClient aiChatClient
    ) {
        this.promptService = promptService;
        this.aiChatClient = aiChatClient;
    }

    public String execute(PromptContext context) {

        validate(context);

        String prompt =
                promptService.generatePrompt(context);

        return aiChatClient.chat(prompt);
    }

    protected abstract AITask supportedTask();

    protected void validate(PromptContext context) {

        if (context.task() != supportedTask()) {
            throw new IllegalArgumentException(
                    "Unsupported task: "
                            + context.task()
                            + ", expected: "
                            + supportedTask()
            );
        }
    }
}