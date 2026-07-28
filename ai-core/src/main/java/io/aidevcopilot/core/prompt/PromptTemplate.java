package io.aidevcopilot.core.prompt;

import io.aidevcopilot.core.task.AITask;

import java.util.Map;

/**
 * Stores prompt templates for different AI tasks.
 */
public final class PromptTemplate {

    private PromptTemplate() {
    }

    private static final Map<AITask, String> TEMPLATES = Map.of(

            AITask.CHAT,
            """
            You are AI Dev Copilot, an expert Java Backend Engineer.

            Answer the following question:

            {{input}}
            """,

            AITask.EXPLAIN_CODE,
            """
            Explain the following Java code.

            Focus on:
            - Purpose
            - Working
            - Time Complexity
            - Space Complexity
            - Possible Improvements

            Code:

            {{input}}
            """,

            AITask.CODE_REVIEW,
            """
            Review the following code.

            Focus on:
            - Bugs
            - Code Smells
            - Performance
            - Security
            - Best Practices

            Code:

            {{input}}
            """,

            AITask.GENERATE_JAVADOC,
            """
            Generate production-ready JavaDoc for the following code.

            Code:

            {{input}}
            """,

            AITask.GENERATE_TESTS,
            """
            Generate JUnit 5 and Mockito unit tests.

            Code:

            {{input}}
            """
    );

    public static String get(AITask task) {
        return TEMPLATES.get(task);
    }
}