package io.aidevcopilot.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(
        name = "ChatRequest",
        description = "Request payload for AI chat"
)
public class ChatRequest {

    @Schema(
            description = "Prompt to send to the AI model",
            example = "Explain Dependency Injection in Spring Boot."
    )
    @NotBlank(message = "Prompt cannot be blank")
    @Size(max = 5000, message = "Prompt cannot exceed 5000 characters")
    private String prompt;

    public ChatRequest() {
    }

    public ChatRequest(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}