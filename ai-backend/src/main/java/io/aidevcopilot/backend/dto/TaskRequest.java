package io.aidevcopilot.backend.dto;

import io.aidevcopilot.core.task.AITask;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskRequest(

        @NotNull
        AITask task,

        @NotBlank
        String input

) {
}