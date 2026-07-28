package io.aidevcopilot.backend.service.impl;

import io.aidevcopilot.backend.service.ChatService;
import io.aidevcopilot.infrastructure.client.ai.AIChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

    private final AIChatClient aiChatClient;

    public ChatServiceImpl(AIChatClient aiChatClient) {
        this.aiChatClient = aiChatClient;
    }

    @Override
    public String chat(String prompt) {
        return aiChatClient.chat(prompt);
    }
}