package io.aidevcopilot.core.prompt;

import io.aidevcopilot.core.model.PromptContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Responsible for generating prompts
 * for different AI tasks.
 */
@Service
@RequiredArgsConstructor
public class PromptService {

    private final PromptBuilder promptBuilder;

    /**
     * Generates the final prompt.
     *
     * @param context Prompt context
     * @return Prompt ready for the LLM
     */
    public String generatePrompt(PromptContext context) {

        String template = PromptTemplate.getTemplate(context.task());

        return promptBuilder.build(
                template,
                context
        );
    }
}