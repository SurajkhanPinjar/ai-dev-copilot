package io.aidevcopilot.plugin.project.analyzer;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.PsiManager;
import io.aidevcopilot.plugin.project.model.ProjectAnalysisResult;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProjectAnalyzer {

    private final List<ProjectFileAnalyzer> analyzers =
            List.of(
                    new StatisticsAnalyzer(),
                    new SpringAnalyzer(),
                    new DependencyAnalyzer()
            );

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

        PsiManager psiManager =
                PsiManager.getInstance(project);

        ProjectFileIndex fileIndex =
                ProjectRootManager.getInstance(project)
                        .getFileIndex();

        fileIndex.iterateContent(
                virtualFile -> {

                    processFile(
                            psiManager,
                            virtualFile,
                            result,
                            packages
                    );

                    return true;
                }
        );

        result.getProjectStatistics()
                .setPackages(
                        packages.size()
                );

        return result;

    }

    private void processFile(
            PsiManager psiManager,
            VirtualFile file,
            ProjectAnalysisResult result,
            Set<String> packages
    ) {

        String extension =
                file.getExtension();

        if (!"java".equalsIgnoreCase(extension)) {
            return;
        }

        if (!(psiManager.findFile(file)
                instanceof PsiJavaFile javaFile)) {
            return;
        }

        String packageName =
                javaFile.getPackageName();

        if (!packageName.isBlank()) {
            packages.add(packageName);
        }

        analyzeJavaFile(
                javaFile,
                result
        );

    }

    private void analyzeJavaFile(
            PsiJavaFile javaFile,
            ProjectAnalysisResult result
    ) {

        for (ProjectFileAnalyzer analyzer :
                analyzers) {

            analyzer.analyze(
                    javaFile,
                    result
            );

        }

    }

}