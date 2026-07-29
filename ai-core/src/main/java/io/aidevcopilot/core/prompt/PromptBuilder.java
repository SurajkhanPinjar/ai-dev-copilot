package io.aidevcopilot.core.prompt;

import io.aidevcopilot.core.model.PromptContext;
import org.springframework.stereotype.Component;

/**
 * Builds the final prompt by replacing
 * template placeholders.
 */
@Component
public class PromptBuilder {

    public String build(
            String template,
            PromptContext context
    ) {

        return template
                .replace(
                        "{{input}}",
                        value(context.input())
                )
                .replace(
                        "{{context}}",
                        value(context.context())
                );
    }

    private String value(String text) {
        return text == null ? "" : text.trim();
    }
}