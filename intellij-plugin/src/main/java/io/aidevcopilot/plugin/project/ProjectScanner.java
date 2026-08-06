package io.aidevcopilot.plugin.project;

import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiAnnotation;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;

public class ProjectScanner {

    public ProjectSummary scan(Project project) {

        ProjectSummary summary =
                new ProjectSummary();

        FileTypeIndex.processFiles(
                JavaFileType.INSTANCE,
                virtualFile -> {

                    scanJavaFile(
                            project,
                            virtualFile,
                            summary
                    );

                    return true;

                },
                GlobalSearchScope.projectScope(project)
        );

        return summary;
    }

    private void scanJavaFile(
            Project project,
            VirtualFile file,
            ProjectSummary summary
    ) {

        PsiJavaFile javaFile =
                ProjectPsiUtil.getJavaFile(
                        project,
                        file
                );

        if (javaFile == null) {
            return;
        }

        summary.incrementJavaFiles();

        if (javaFile.getPackageName() != null &&
                !javaFile.getPackageName().isBlank()) {

            summary.incrementPackages();

        }

        for (PsiClass psiClass : javaFile.getClasses()) {

            scanClass(
                    psiClass,
                    summary
            );

        }

    }

    private void scanClass(
            PsiClass psiClass,
            ProjectSummary summary
    ) {

        if (psiClass.isInterface()) {

            summary.incrementInterfaces();

        } else if (psiClass.isEnum()) {

            summary.incrementEnums();

        } else if (psiClass.isRecord()) {

            summary.incrementRecords();

        } else {

            summary.incrementClasses();

        }

        scanSpringAnnotations(
                psiClass,
                summary
        );

    }

    private void scanSpringAnnotations(
            PsiClass psiClass,
            ProjectSummary summary
    ) {

        for (PsiAnnotation annotation :
                psiClass.getModifierList().getAnnotations()) {

            String name =
                    annotation.getQualifiedName();

            if (name == null) {
                continue;
            }

            switch (name) {

                case "org.springframework.stereotype.Controller" ->
                        summary.incrementControllers();

                case "org.springframework.web.bind.annotation.RestController" ->
                        summary.incrementRestControllers();

                case "org.springframework.stereotype.Service" ->
                        summary.incrementServices();

                case "org.springframework.stereotype.Repository" ->
                        summary.incrementRepositories();

                case "jakarta.persistence.Entity",
                     "javax.persistence.Entity" ->
                        summary.incrementEntities();

                case "org.springframework.context.annotation.Configuration" ->
                        summary.incrementConfigurations();

                case "org.springframework.stereotype.Component" ->
                        summary.incrementComponents();

            }

        }

    }

}