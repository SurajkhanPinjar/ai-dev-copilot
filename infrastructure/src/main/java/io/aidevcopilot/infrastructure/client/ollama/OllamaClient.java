package io.aidevcopilot.infrastructure.client.ollama;

import dev.langchain4j.model.chat.ChatModel;
import io.aidevcopilot.ports.llm.AIChatClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OllamaClient implements AIChatClient {

    private static final Logger log =
            LoggerFactory.getLogger(OllamaClient.class);

    private final ChatModel chatModel;

    public OllamaClient(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @Override
    public String chat(String prompt) {

        log.info("Sending request to Ollama. PromptLength={}", prompt.length());

        long start = System.currentTimeMillis();

        try {
            String response = chatModel.chat(prompt);

            long duration = System.currentTimeMillis() - start;

            log.info("Received response from Ollama in {} ms", duration);

            return response;

        } catch (Exception ex) {

            log.error("Failed to communicate with Ollama", ex);

            throw ex;
        }
    }

    @Override
    public boolean isAvailable() {

        log.info("Checking Ollama availability");

        try {

            chatModel.chat("ping");

            log.info("Ollama is available");

            return true;

        } catch (Exception ex) {

            log.error("Ollama availability check failed", ex);

            return false;
        }
    }
}