package io.aidevcopilot.plugin.project.service;

import com.intellij.openapi.application.ReadAction;
import com.intellij.openapi.project.Project;
import io.aidevcopilot.plugin.project.analyzer.ProjectAnalyzer;
import io.aidevcopilot.plugin.project.model.ProjectAnalysisResult;

public class ProjectAnalysisService {

    private final ProjectAnalyzer analyzer =
            new ProjectAnalyzer();

    /**
     * Analyze the IntelliJ project.
     */

    public ProjectAnalysisResult analyze(
            Project project
    ) {

        if (project == null) {
            throw new IllegalArgumentException(
                    "Project not found."
            );
        }

        return ReadAction.compute(
                () -> analyzer.analyze(project)
        );

    }

}