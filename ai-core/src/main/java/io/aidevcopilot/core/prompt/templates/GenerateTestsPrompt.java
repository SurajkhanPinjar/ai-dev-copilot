package io.aidevcopilot.core.prompt.templates;

import io.aidevcopilot.core.prompt.PromptTemplate;

public final class GenerateTestsPrompt implements PromptTemplate {

    @Override
    public String template() {

        return """
                You are a Senior Java Backend Engineer.

                Generate production-quality unit tests for the following code.

                Requirements:

                • Use JUnit 5
                • Use Mockito where required
                • Follow Arrange-Act-Assert (AAA) pattern
                • Cover happy path
                • Cover edge cases
                • Cover exception scenarios
                • Use meaningful test method names
                • Include all required imports

                Return only the Java test class.

                Code:

                {{input}}
                """;
    }
}