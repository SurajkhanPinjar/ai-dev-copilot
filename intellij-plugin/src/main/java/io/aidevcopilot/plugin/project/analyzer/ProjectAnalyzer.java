package io.aidevcopilot.plugin.project.analyzer;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.PsiManager;
import io.aidevcopilot.plugin.project.model.ProjectAnalysisResult;
import io.aidevcopilot.plugin.project.scope.AnalysisContext;
import io.aidevcopilot.plugin.project.scope.AnalysisScope;

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
            AnalysisContext context
    ) {

        ProjectAnalysisResult result =
                new ProjectAnalysisResult();

        if (context == null) {
            return result;
        }

        Project project =
                context.getProject();

        VirtualFile root =
                context.getRoot();

        AnalysisScope scope =
                context.getScope();

        if (project == null || root == null) {
            return result;
        }

        PsiManager psiManager =
                PsiManager.getInstance(project);

        Set<String> packages =
                new HashSet<>();

        switch (scope) {

            case PROJECT ->
                    scanProject(
                            project,
                            psiManager,
                            result,
                            packages
                    );

            case MODULE,
                 PACKAGE ->
                    scanDirectory(
                            psiManager,
                            root,
                            result,
                            packages
                    );

            case FILE ->
                    processFile(
                            psiManager,
                            root,
                            result,
                            packages
                    );

        }

        result.getProjectStatistics()
                .setPackages(packages.size());

        return result;

    }

    private void scanProject(
            Project project,
            PsiManager psiManager,
            ProjectAnalysisResult result,
            Set<String> packages
    ) {

        ProjectFileIndex fileIndex =
                ProjectRootManager.getInstance(project)
                        .getFileIndex();

        fileIndex.iterateContent(
                file -> {

                    processFile(
                            psiManager,
                            file,
                            result,
                            packages
                    );

                    return true;
                }
        );

    }

    private void scanDirectory(
            PsiManager psiManager,
            VirtualFile directory,
            ProjectAnalysisResult result,
            Set<String> packages
    ) {

        if (directory.isDirectory()) {

            for (VirtualFile child :
                    directory.getChildren()) {

                scanDirectory(
                        psiManager,
                        child,
                        result,
                        packages
                );

            }

            return;

        }

        processFile(
                psiManager,
                directory,
                result,
                packages
        );

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