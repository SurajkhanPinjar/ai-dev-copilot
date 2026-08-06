package io.aidevcopilot.core.prompt.templates;

import io.aidevcopilot.core.prompt.PromptTemplate;

public final class OptimizerPrompt implements PromptTemplate {

    @Override
    public String template() {

        return """
                You are a Senior Java Performance Engineer.

                Your task is to optimize the following Java code.

                Goals:
                - Improve performance.
                - Reduce unnecessary object creation.
                - Improve readability.
                - Improve maintainability.
                - Follow Java 21 best practices.
                - Preserve the original behaviour.
                - Keep the code fully compilable.

                IMPORTANT RULES

                Return ONLY the complete optimized Java source code.

                DO NOT:
                - Explain your changes.
                - Add analysis.
                - Add headings.
                - Add markdown.
                - Wrap the code with ```java.
                - Add comments outside the code.
                - Add any text before or after the code.

                The output MUST begin with one of:

                package ...
                import ...
                public ...
                class ...
                interface ...
                enum ...
                record ...

                The output MUST end with the final closing brace of the Java code.

                Java Code:

                {{input}}
                """;
    }
}