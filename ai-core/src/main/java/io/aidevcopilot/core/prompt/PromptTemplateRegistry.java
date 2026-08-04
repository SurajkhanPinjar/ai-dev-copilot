package io.aidevcopilot.core.prompt;

import io.aidevcopilot.core.prompt.templates.*;
import io.aidevcopilot.core.task.AITask;

import java.util.Map;

public final class PromptTemplateRegistry {

    private PromptTemplateRegistry() {
    }

    private static final Map<AITask, PromptTemplate> TEMPLATES =
            Map.of(
                    AITask.CHAT, new ChatPrompt(),
                    AITask.EXPLAIN_CODE, new ExplainCodePrompt(),
                    AITask.BUG_FINDER, new BugFinderPrompt(),
                    AITask.GENERATE_JAVADOC, new JavaDocPrompt(),
                    AITask.OPTIMIZE_CODE, new OptimizerPrompt(),
                    AITask.SQL_EXPLAIN, new SqlPrompt(),
                    AITask.SPRING_BOOT_ADVISOR, new SpringAdvisorPrompt(),
                    AITask.ARCHITECTURE_REVIEWER, new ArchitectureReviewPrompt(),
                    AITask.GENERATE_TESTS, new GenerateTestsPrompt()
            );

    public static String getTemplate(AITask task) {

        PromptTemplate prompt = TEMPLATES.get(task);

        if (prompt == null) {
            throw new IllegalArgumentException(
                    "No prompt found for task: " + task
            );
        }

        return prompt.template();
    }
}