package io.aidevcopilot.core.prompt.templates;

import io.aidevcopilot.core.prompt.PromptTemplate;

public final class BugFinderPrompt implements PromptTemplate {

    @Override
    public String template() {

        return """
                You are a Senior Java Backend Engineer.

                Analyze the following Java code.

                Only report bugs that actually exist.
                Do not invent problems.
                If no issues are found, explicitly respond:

                "No significant issues found."

                Identify:

                1. Potential Bugs
                2. Severity
                3. Root Cause
                4. Runtime Exceptions
                5. Null Pointer Risks
                6. Concurrency Issues
                7. Resource Leaks
                8. Security Issues
                9. Performance Issues
                10. Suggested Fixes
                11. Improved Code

                Return the answer using the following sections:

                ## Potential Bugs

                ## Severity

                ## Explanation

                ## Suggested Fix

                ## Improved Code

                Code:

                {{input}}
                """;
    }
}