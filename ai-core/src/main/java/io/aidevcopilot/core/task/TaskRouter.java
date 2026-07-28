package io.aidevcopilot.core.task;

import io.aidevcopilot.core.model.PromptContext;
import org.springframework.stereotype.Service;

/**
 * Routes incoming AI tasks to the appropriate task service.
 */
@Service
public class TaskRouter {

    private final ChatTaskService chatTaskService;
    private final ExplainCodeService explainCodeService;
    private final JavaDocService javaDocService;
    private final TestGenerationService testGenerationService;

    public TaskRouter(ChatTaskService chatTaskService,
                      ExplainCodeService explainCodeService,
                      JavaDocService javaDocService,
                      TestGenerationService testGenerationService) {

        this.chatTaskService = chatTaskService;
        this.explainCodeService = explainCodeService;
        this.javaDocService = javaDocService;
        this.testGenerationService = testGenerationService;
    }

    /**
     * Routes the request to the appropriate AI task service.
     *
     * @param context prompt context
     * @return AI response
     */
    public String execute(PromptContext context) {

        return switch (context.task()) {

            case CHAT ->
                    chatTaskService.execute(context);

            case EXPLAIN_CODE ->
                    explainCodeService.execute(context);

            case GENERATE_JAVADOC ->
                    javaDocService.execute(context);

            case GENERATE_TESTS ->
                    testGenerationService.execute(context);

            default ->
                    throw new UnsupportedOperationException(
                            "Task not implemented: " + context.task());
        };
    }
}