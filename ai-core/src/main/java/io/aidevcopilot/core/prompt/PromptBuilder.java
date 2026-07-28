package io.aidevcopilot.core.prompt;

import io.aidevcopilot.core.model.PromptContext;

import java.util.Objects;

/**
 * Builds the final prompt by replacing template placeholders
 * with runtime values.
 */
public class PromptBuilder {

    /**
     * Builds the final prompt for the given context.
     *
     * @param context Prompt context
     * @return Final prompt ready to send to the LLM
     */
    public String build(PromptContext context) {

        Objects.requireNonNull(context, "PromptContext cannot be null");

        String template = PromptTemplate.get(context.task());

        if (template == null) {
            throw new IllegalArgumentException(
                    "No prompt template found for task: " + context.task());
        }

        return template.replace(
                "{{input}}",
                context.input() == null ? "" : context.input().trim()
        );
    }
}