package io.aidevcopilot.plugin.project.analyzer;

import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiJavaFile;
import io.aidevcopilot.plugin.project.model.ProjectAnalysisResult;
import io.aidevcopilot.plugin.project.model.ProjectStatistics;

public class StatisticsAnalyzer
        implements ProjectFileAnalyzer {

    @Override
    public void analyze(
            PsiJavaFile javaFile,
            ProjectAnalysisResult result
    ) {

        if (javaFile == null) {
            return;
        }

        ProjectStatistics statistics =
                result.getProjectStatistics();

        statistics.setJavaFiles(
                statistics.getJavaFiles() + 1
        );

        for (PsiClass psiClass : javaFile.getClasses()) {

            if (psiClass.isInterface()) {

                statistics.setInterfaces(
                        statistics.getInterfaces() + 1
                );

            } else if (psiClass.isEnum()) {

                statistics.setEnums(
                        statistics.getEnums() + 1
                );

            } else if (psiClass.isRecord()) {

                statistics.setRecords(
                        statistics.getRecords() + 1
                );

            } else {

                statistics.setClasses(
                        statistics.getClasses() + 1
                );

            }

        }

    }

}