package io.aidevcopilot.core.prompt.templates;

import io.aidevcopilot.core.prompt.PromptTemplate;

public final class JavaDocPrompt implements PromptTemplate {

    @Override
    public String template() {

        return """
                You are a Senior Java Backend Engineer.

                Your task is to generate professional, production-ready JavaDoc for the given Java code.

                Requirements:
                - Generate class-level JavaDoc where applicable.
                - Generate JavaDoc for all public and protected methods.
                - Document every parameter using @param.
                - Document return values using @return.
                - Document thrown exceptions using @throws where applicable.
                - Follow Oracle JavaDoc conventions.
                - Preserve the existing code behaviour.
                - Do not modify business logic.
                - Keep the code fully compilable.

                IMPORTANT RULES

                Return ONLY the complete updated Java source code.

                DO NOT:
                - Explain your changes.
                - Add analysis.
                - Add headings.
                - Add markdown.
                - Wrap the code with ```java.
                - Add any text before or after the Java code.

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