package io.aidevcopilot.core.prompt.templates;

import io.aidevcopilot.core.prompt.PromptTemplate;

public final class SqlPrompt implements PromptTemplate {

    @Override
    public String template() {

        return """
                You are a Senior Database Engineer.

                Explain the following SQL query.

                Analyze:

                1. Purpose
                2. Step-by-step Execution
                3. Tables Used
                4. Join Types
                5. WHERE Clause
                6. GROUP BY
                7. ORDER BY
                8. Index Usage
                9. Performance Analysis
                10. Possible Optimizations

                Return the answer using:

                ## Query Purpose

                ## Execution Flow

                ## Performance Analysis

                ## Optimization Suggestions

                ## Improved SQL

                SQL:

                {{input}}
                """;
    }
}