package io.aidevcopilot.core.model;

import io.aidevcopilot.core.task.AITask;

/**
 * Context used while constructing prompts.
 */
public record PromptContext(

        AITask task,

        String input,

        String context
) {
}