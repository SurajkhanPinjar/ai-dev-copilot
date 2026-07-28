package io.aidevcopilot.core.prompt;

import io.aidevcopilot.core.model.PromptContext;
import org.springframework.stereotype.Service;

/**
 * Responsible for generating prompts
 * for different AI tasks.
 */
@Service
public class PromptService {

    private final PromptBuilder promptBuilder;

    public PromptService() {
        this.promptBuilder = new PromptBuilder();
    }

    /**
     * Generates the final prompt.
     *
     * @param context Prompt context
     * @return Prompt ready for the LLM
     */
    public String generatePrompt(PromptContext context) {
        return promptBuilder.build(context);
    }

}