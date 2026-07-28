package io.aidevcopilot.infrastructure.client.ai;

public interface AIChatClient {

    String chat(String prompt);

    boolean isAvailable();

}
