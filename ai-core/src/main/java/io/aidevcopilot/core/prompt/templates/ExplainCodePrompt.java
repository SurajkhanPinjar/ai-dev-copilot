package io.aidevcopilot.core.prompt.templates;

import io.aidevcopilot.core.prompt.PromptTemplate;

public class ExplainCodePrompt implements PromptTemplate {

    @Override
    public String template() {

        return """
                You are a Senior Java Backend Engineer.

                Analyze the following code.

                Explain:

                1. Purpose
                2. Step-by-step execution
                3. Classes and methods
                4. Design Pattern
                5. SOLID Principles
                6. Time Complexity
                7. Space Complexity
                8. Best Practices
                9. Possible Improvements

                Code:

                {{input}}
                """;
    }
}