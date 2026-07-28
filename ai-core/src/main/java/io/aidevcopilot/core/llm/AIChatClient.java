package io.aidevcopilot.core.llm;

public interface AIChatClient {

    String chat(String prompt);

    boolean isAvailable();

}
