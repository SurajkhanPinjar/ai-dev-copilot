package io.aidevcopilot.core.prompt.templates;

import io.aidevcopilot.core.prompt.PromptTemplate;

public final class OptimizerPrompt implements PromptTemplate {

    @Override
    public String template() {

        return """
                You are a Senior Java Performance Engineer.

                Optimize the following Java code.

                Analyze:

                1. Performance Bottlenecks
                2. Time Complexity
                3. Space Complexity
                4. Memory Usage
                5. Object Creation
                6. Collections Usage
                7. Stream API Improvements
                8. Thread Safety
                9. Readability
                10. Best Practices

                Return the answer using:

                ## Current Analysis

                ## Problems

                ## Optimizations

                ## Complexity Comparison

                ## Optimized Code

                Code:

                {{input}}
                """;
    }
}