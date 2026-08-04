package io.aidevcopilot.core.prompt.templates;

import io.aidevcopilot.core.prompt.PromptTemplate;

public final class ArchitectureReviewPrompt implements PromptTemplate {

    @Override
    public String template() {

        return """
                You are a Principal Software Architect.

                Review the following architecture, design, or code.

                Analyze the following aspects:

                1. Overall Architecture
                2. Scalability
                3. Reliability
                4. Performance
                5. Security
                6. Maintainability
                7. Design Patterns Used
                8. SOLID Principles
                9. Possible Bottlenecks
                10. Recommendations
                11. Improved Architecture

                Return the answer using the following sections:

                ## Architecture Summary

                ## Strengths

                ## Weaknesses

                ## Bottlenecks

                ## Scalability Review

                ## Security Review

                ## Recommendations

                ## Improved Design

                Input:

                {{input}}
                """;
    }
}