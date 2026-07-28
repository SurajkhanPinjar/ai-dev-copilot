package io.aidevcopilot.core.task;

import io.aidevcopilot.core.llm.AIChatClient;
import io.aidevcopilot.core.model.PromptContext;
import io.aidevcopilot.core.prompt.PromptService;

/**
 * Base class for all AI task services.
 *
 * Handles:
 * - Prompt generation
 * - AI model invocation
 *
 * Subclasses only define which task they support.
 */
public abstract class AbstractAITaskService {

    protected final PromptService promptService;
    protected final AIChatClient aiChatClient;

    protected AbstractAITaskService(PromptService promptService,
                                    AIChatClient aiChatClient) {
        this.promptService = promptService;
        this.aiChatClient = aiChatClient;
    }

    /**
     * Execute the AI task.
     */
    public String execute(PromptContext context) {

        validate(context);

        String prompt = promptService.generatePrompt(context);

        return aiChatClient.chat(prompt);
    }

    /**
     * Returns the task handled by this service.
     */
    protected abstract AITask supportedTask();

    /**
     * Validates the incoming task.
     */
    protected void validate(PromptContext context) {

        if (context.task() != supportedTask()) {
            throw new IllegalArgumentException(
                    "Unsupported task: " + context.task()
                            + ", expected: " + supportedTask());
        }
    }
}