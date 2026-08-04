package io.aidevcopilot.core.prompt.templates;

import io.aidevcopilot.core.prompt.PromptTemplate;

public final class JavaDocPrompt implements PromptTemplate {

    @Override
    public String template() {

        return """
                You are a Senior Java Backend Engineer.

                Generate clean, production-ready JavaDoc for the following Java code.

                Requirements:

                • Generate class-level JavaDoc if applicable
                • Generate method-level JavaDoc
                • Explain every parameter
                • Explain the return value
                • Mention thrown exceptions if applicable
                • Follow Oracle JavaDoc conventions
                • Keep the documentation concise and professional

                Return only the updated Java code with JavaDoc.

                Code:

                {{input}}
                """;
    }
}