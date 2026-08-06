package io.aidevcopilot.plugin.project.analyzer;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.PsiManager;
import io.aidevcopilot.plugin.project.model.ProjectAnalysisResult;

import java.util.HashSet;
import java.util.Set;

public class ProjectAnalyzer {

    private final StatisticsAnalyzer statisticsAnalyzer =
            new StatisticsAnalyzer();

    private final SpringAnalyzer springAnalyzer =
            new SpringAnalyzer();

    public ProjectAnalysisResult analyze(
            Project project
    ) {

        ProjectAnalysisResult result =
                new ProjectAnalysisResult();

        if (project == null) {
            return result;
        }

        Set<String> packages =
                new HashSet<>();

        ProjectFileIndex fileIndex =
                ProjectRootManager.getInstance(project)
                        .getFileIndex();

        fileIndex.iterateContent(

                virtualFile -> {

                    processFile(
                            project,
                            virtualFile,
                            result,
                            packages
                    );

                    return true;
                }

        );

        result.getProjectStatistics()
                .setPackages(packages.size());

        return result;

    }

    private void processFile(
            Project project,
            VirtualFile file,
            ProjectAnalysisResult result,
            Set<String> packages
    ) {

        if (!"java".equalsIgnoreCase(
                file.getExtension()
        )) {
            return;
        }

        if (!(PsiManager.getInstance(project)
                .findFile(file) instanceof PsiJavaFile javaFile)) {
            return;
        }

        packages.add(
                javaFile.getPackageName()
        );

        result.getProjectStatistics()
                .setPackages(packages.size());

        statisticsAnalyzer.analyze(
                javaFile,
                result
        );

        springAnalyzer.analyze(
                javaFile,
                result
        );

    }

}