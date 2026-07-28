package io.aidevcopilot.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ChatRequest {

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