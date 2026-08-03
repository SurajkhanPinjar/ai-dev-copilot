package io.aidevcopilot.backend.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record SearchRequest(

        @NotBlank(message = "Question cannot be empty")
        String question,

        @Min(value = 1, message = "topK must be greater than zero")
        Integer topK

) {
}