package io.aidevcopilot.plugin.project.analyzer;

import com.intellij.psi.PsiAnnotation;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiJavaFile;
import io.aidevcopilot.plugin.project.model.ProjectAnalysisResult;
import io.aidevcopilot.plugin.project.model.SpringStatistics;

public class SpringAnalyzer
        implements ProjectFileAnalyzer {

    @Override
    public void analyze(
            PsiJavaFile javaFile,
            ProjectAnalysisResult result
    ) {

        if (javaFile == null) {
            return;
        }

        SpringStatistics statistics =
                result.getSpringStatistics();

        for (PsiClass psiClass : javaFile.getClasses()) {

            analyzeClass(
                    psiClass,
                    statistics
            );

        }

    }

    private void analyzeClass(
            PsiClass psiClass,
            SpringStatistics statistics
    ) {

        if (psiClass.getModifierList() == null) {
            return;
        }

        for (PsiAnnotation annotation :
                psiClass.getModifierList().getAnnotations()) {

            String qualifiedName =
                    annotation.getQualifiedName();

            if (qualifiedName == null) {
                continue;
            }

            switch (qualifiedName) {

                case "org.springframework.stereotype.Controller" ->
                        statistics.setControllers(
                                statistics.getControllers() + 1
                        );

                case "org.springframework.web.bind.annotation.RestController" ->
                        statistics.setRestControllers(
                                statistics.getRestControllers() + 1
                        );

                case "org.springframework.stereotype.Service" ->
                        statistics.setServices(
                                statistics.getServices() + 1
                        );

                case "org.springframework.stereotype.Repository" ->
                        statistics.setRepositories(
                                statistics.getRepositories() + 1
                        );

                case "org.springframework.stereotype.Component" ->
                        statistics.setComponents(
                                statistics.getComponents() + 1
                        );

                case "org.springframework.context.annotation.Configuration" ->
                        statistics.setConfigurations(
                                statistics.getConfigurations() + 1
                        );

                case "jakarta.persistence.Entity",
                     "javax.persistence.Entity" ->
                        statistics.setEntities(
                                statistics.getEntities() + 1
                        );

            }

        }

    }

}