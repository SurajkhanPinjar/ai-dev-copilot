package io.aidevcopilot.core.task;

import io.aidevcopilot.core.model.PromptContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Routes incoming AI tasks to the appropriate task service.
 */
@Service
@RequiredArgsConstructor
public class TaskRouter {

    private final ChatTaskService chatTaskService;
    private final ExplainCodeService explainCodeService;
    private final JavaDocService javaDocService;
    private final TestGenerationService testGenerationService;
    private final BugFinderService bugFinderService;
    private final CodeOptimizerService codeOptimizerService;
    private final SpringBootAdviserService springBootAdviserService;
    private final SQLExplainerService sqlExplainerService;
    private final ArchitectureReviewerService architectureReviewerService;




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

            case BUG_FINDER ->
                    bugFinderService.execute(context);

            case OPTIMIZE_CODE ->
                    codeOptimizerService.execute(context);

            case SPRING_BOOT_ADVISOR ->
                    springBootAdviserService.execute(context);

            case SQL_EXPLAIN ->
                    sqlExplainerService.execute(context);

            case ARCHITECTURE_REVIEWER ->
                    architectureReviewerService.execute(context);


            default ->
                    throw new UnsupportedOperationException(
                            "Task not implemented: " + context.task());
        };
    }
}