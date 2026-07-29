package io.aidevcopilot.ports.llm;

public interface AIChatClient {

    String chat(String prompt);

    boolean isAvailable();

}
