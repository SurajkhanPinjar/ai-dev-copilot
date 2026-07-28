package io.aidevcopilot.backend.controller;

import io.aidevcopilot.backend.dto.ChatRequest;
import io.aidevcopilot.backend.dto.ChatResponse;
import io.aidevcopilot.backend.service.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {

        String response = chatService.chat(request.getPrompt());

        return new ChatResponse(response);
    }
}