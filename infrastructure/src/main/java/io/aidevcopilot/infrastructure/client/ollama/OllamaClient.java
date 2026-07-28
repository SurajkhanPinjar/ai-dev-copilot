package io.aidevcopilot.infrastructure.client.ollama;

import dev.langchain4j.model.chat.ChatModel;
import io.aidevcopilot.infrastructure.client.ai.AIChatClient;
import org.springframework.stereotype.Component;

@Component
public class OllamaClient implements AIChatClient {

    private final ChatModel chatModel;

    public OllamaClient(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @Override
    public String chat(String prompt) {
        return chatModel.chat(prompt);
    }

    @Override
    public boolean isAvailable() {
        try {
            chatModel.chat("ping");
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}