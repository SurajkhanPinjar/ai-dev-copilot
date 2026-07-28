package io.aidevcopilot.backend.controller;

import io.aidevcopilot.backend.dto.ApiResponse;
import io.aidevcopilot.backend.dto.ChatRequest;
import io.aidevcopilot.backend.dto.ChatResponse;
import io.aidevcopilot.backend.service.ChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/chat")
@Tag(
        name = "AI Chat",
        description = "Endpoints for interacting with the AI model"
)
public class ChatController {

    private static final Logger log =
            LoggerFactory.getLogger(ChatController.class);

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    @Operation(
            summary = "Chat with AI",
            description = "Sends a prompt to the configured AI model and returns an AI-generated response."
    )
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Chat response generated successfully"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "400",
                    description = "Validation failed"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500",
                    description = "Internal server error"
            )
    })
    public ResponseEntity<ApiResponse<ChatResponse>> chat(
            @Valid @RequestBody ChatRequest request) {

        log.info("Received chat request. PromptLength={}",
                request.getPrompt().length());

        long startTime = System.currentTimeMillis();

        String response = chatService.chat(request.getPrompt());

        long executionTime = System.currentTimeMillis() - startTime;

        log.info("Chat response generated successfully in {} ms",
                executionTime);

        ChatResponse chatResponse = new ChatResponse(response);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        LocalDateTime.now(),
                        chatResponse
                )
        );
    }
}