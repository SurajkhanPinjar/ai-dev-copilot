package io.aidevcopilot.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "ChatResponse",
        description = "Response returned by the AI model"
)
public class ChatResponse {

    @Schema(
            description = "AI-generated response",
            example = "Dependency Injection is a design pattern that allows objects to receive their dependencies from an external source rather than creating them internally."
    )
    private String response;

    public ChatResponse() {
    }

    public ChatResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}