package io.aidevcopilot.plugin.project.analyzer;

import com.intellij.psi.PsiJavaFile;
import io.aidevcopilot.plugin.project.model.ProjectAnalysisResult;

public interface ProjectFileAnalyzer {

    void analyze(
            PsiJavaFile javaFile,
            ProjectAnalysisResult result
    );

}