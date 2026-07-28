package io.aidevcopilot.backend.service.impl;

import io.aidevcopilot.backend.service.ChatService;
import io.aidevcopilot.infrastructure.client.ai.AIChatClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

    private static final Logger log =
            LoggerFactory.getLogger(ChatServiceImpl.class);

    private final AIChatClient aiChatClient;

    public ChatServiceImpl(AIChatClient aiChatClient) {
        this.aiChatClient = aiChatClient;
    }

    @Override
    public String chat(String prompt) {

        log.info("Processing chat request");

        String response = aiChatClient.chat(prompt);

        log.info("Chat request processed successfully");

        return response;
    }
}