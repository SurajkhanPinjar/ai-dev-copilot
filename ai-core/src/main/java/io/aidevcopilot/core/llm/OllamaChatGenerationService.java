package io.aidevcopilot.core.llm;

import dev.langchain4j.model.chat.ChatModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OllamaChatGenerationService
        implements ChatGenerationService {

    private final ChatModel chatModel;

    @Override
    public String generate(String prompt) {

        return chatModel.chat(prompt);

    }
}