package io.aidevcopilot.plugin.project.analyzer;

import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.PsiType;
import io.aidevcopilot.plugin.project.model.DependencyEdge;
import io.aidevcopilot.plugin.project.model.DependencyGraph;
import io.aidevcopilot.plugin.project.model.DependencyNode;
import io.aidevcopilot.plugin.project.model.ProjectAnalysisResult;
import io.aidevcopilot.plugin.project.util.DependencyFilter;

public class DependencyAnalyzer
        implements ProjectFileAnalyzer {

    @Override
    public void analyze(
            PsiJavaFile javaFile,
            ProjectAnalysisResult result
    ) {

        if (javaFile == null) {
            return;
        }

        DependencyGraph graph =
                result.getDependencyGraph();

        for (PsiClass psiClass : javaFile.getClasses()) {

            analyzeClass(
                    psiClass,
                    graph
            );

        }

    }

    private void analyzeClass(
            PsiClass psiClass,
            DependencyGraph graph
    ) {

        DependencyNode node =
                new DependencyNode();

        node.setClassName(
                psiClass.getName()
        );

        node.setPackageName(
                psiClass.getQualifiedName()
        );

        node.setType(
                detectType(psiClass)
        );

        graph.getNodes().add(node);

        for (PsiField field :
                psiClass.getFields()) {

            createDependency(
                    psiClass,
                    field,
                    graph
            );

        }

    }

    private void createDependency(
            PsiClass fromClass,
            PsiField field,
            DependencyGraph graph
    ) {

        PsiType type =
                field.getType();

        String dependency =
                type.getPresentableText();

        if (DependencyFilter.shouldIgnore(
                dependency
        )) {
            return;
        }

        DependencyEdge edge =
                new DependencyEdge();

        edge.setFrom(
                fromClass.getName()
        );

        edge.setTo(
                dependency
        );

        graph.getEdges().add(edge);

    }

    private String detectType(
            PsiClass psiClass
    ) {

        if (psiClass.isInterface()) {
            return "Interface";
        }

        if (psiClass.isEnum()) {
            return "Enum";
        }

        if (psiClass.isRecord()) {
            return "Record";
        }

        return "Class";
    }

}