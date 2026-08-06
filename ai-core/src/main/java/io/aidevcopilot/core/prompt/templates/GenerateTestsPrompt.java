package io.aidevcopilot.core.prompt.templates;

import io.aidevcopilot.core.prompt.PromptTemplate;

public final class GenerateTestsPrompt implements PromptTemplate {

    @Override
    public String template() {

        return """
                You are a Senior Java Backend Engineer.

                Your task is to generate production-ready unit tests for the given Java code.

                Requirements:
                - Use JUnit 5.
                - Use Mockito where required.
                - Follow the Arrange-Act-Assert (AAA) pattern.
                - Cover happy path scenarios.
                - Cover edge cases.
                - Cover exception scenarios.
                - Use meaningful test method names.
                - Include all required imports.
                - Keep the generated test class fully compilable.

                IMPORTANT RULES

                Return ONLY the complete Java test class.

                DO NOT:
                - Explain your solution.
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

                The output MUST end with the final closing brace of the Java class.

                Java Code:

                {{input}}
                """;
    }

}