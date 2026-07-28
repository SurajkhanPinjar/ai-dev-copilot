package io.aidevcopilot.core.task;

/**
 * Represents all AI capabilities supported by AI Dev Copilot.
 *
 * New AI features should be added here instead of creating
 * separate endpoints for every capability.
 */
public enum AITask {

    /**
     * General conversational AI.
     */
    CHAT,

    /**
     * Explain source code.
     */
    EXPLAIN_CODE,

    /**
     * Review source code and provide suggestions.
     */
    CODE_REVIEW,

    /**
     * Generate JavaDoc.
     */
    GENERATE_JAVADOC,

    /**
     * Generate Unit Tests.
     */
    GENERATE_TESTS,

    /**
     * Optimize source code.
     */
    OPTIMIZE_CODE,

    /**
     * Explain SQL queries.
     */
    EXPLAIN_SQL,

    /**
     * Generate SQL queries.
     */
    GENERATE_SQL,

    /**
     * Analyze stack traces.
     */
    ANALYZE_STACKTRACE,

    /**
     * Generate Spring Boot REST APIs.
     */
    GENERATE_API,

    RAG_CHAT,
    /**
     * Generate Spring Boot service layer.
     */
    GENERATE_SPRING_SERVICE

}