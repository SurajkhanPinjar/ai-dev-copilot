package io.aidevcopilot.core.prompt.templates;

import io.aidevcopilot.core.prompt.PromptTemplate;

public final class SpringAdvisorPrompt implements PromptTemplate {

    @Override
    public String template() {

        return """
                You are a Principal Spring Boot Architect.

                Review the following Spring Boot code.

                Analyze:

                1. Spring Best Practices
                2. Dependency Injection
                3. Bean Lifecycle
                4. Transaction Management
                5. Exception Handling
                6. Validation
                7. Security
                8. Performance
                9. Clean Architecture
                10. Microservice Readiness

                Return the answer using:

                ## Overall Review

                ## Issues Found

                ## Spring Best Practices

                ## Performance Suggestions

                ## Security Suggestions

                ## Improved Code

                Code:

                {{input}}
                """;
    }
}