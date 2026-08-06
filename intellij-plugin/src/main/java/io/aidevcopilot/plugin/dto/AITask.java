package io.aidevcopilot.plugin.dto;

public enum AITask {

    CHAT("Chat"),
    EXPLAIN_CODE("Explain Code"),
    BUG_FINDER("Bug Finder"),
    CODE_REVIEW("Code Review"),
    GENERATE_JAVADOC("Generate JavaDoc"),
    GENERATE_TESTS("Generate Tests"),
    OPTIMIZE_CODE("Optimize Code"),
    SPRING_BOOT_ADVISOR("Spring Boot Advisor"),
    SQL_EXPLAIN("SQL Explain"),
    ARCHITECTURE_REVIEWER("Architecture Review");

    private final String displayName;

    AITask(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}