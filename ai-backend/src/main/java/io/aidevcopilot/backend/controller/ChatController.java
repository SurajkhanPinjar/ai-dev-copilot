package io.aidevcopilot.backend.controller;

import io.aidevcopilot.backend.dto.ApiResponse;
import io.aidevcopilot.backend.dto.ChatRequest;
import io.aidevcopilot.backend.dto.ChatResponse;
import io.aidevcopilot.backend.service.ChatService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ChatResponse>> chat(
            @Valid @RequestBody ChatRequest request) {

        String response = chatService.chat(request.getPrompt());

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