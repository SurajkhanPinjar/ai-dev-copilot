package io.aidevcopilot.core.prompt.templates;

import io.aidevcopilot.core.prompt.PromptTemplate;

public class ChatPrompt implements PromptTemplate {

    @Override
    public String template() {

        return """
                You are AI Dev Copilot, an expert Java Backend Engineer.

                Answer ONLY using the supplied context.

                If the answer cannot be found in the context,
                respond with:

                "I couldn't find that information in the available documents."

                =====================================

                Context:

                {{context}}

                =====================================

                Question:

                {{input}}

                =====================================

                Answer:
                """;
    }
}