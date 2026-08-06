package io.aidevcopilot.plugin.project.service;

import com.intellij.openapi.application.ReadAction;
import io.aidevcopilot.plugin.project.analyzer.ProjectAnalyzer;
import io.aidevcopilot.plugin.project.model.ProjectAnalysisResult;
import io.aidevcopilot.plugin.project.scope.AnalysisContext;

public class ProjectAnalysisService {

    private final ProjectAnalyzer analyzer =
            new ProjectAnalyzer();

    /**
     * Analyze the selected scope.
     */
    public ProjectAnalysisResult analyze(
            AnalysisContext context
    ) {

        if (context == null) {
            throw new IllegalArgumentException(
                    "Analysis context not found."
            );
        }

        return ReadAction.compute(
                () -> analyzer.analyze(context)
        );

    }

}