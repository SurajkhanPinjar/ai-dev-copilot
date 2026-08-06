package io.aidevcopilot.plugin.project.model;

public class ProjectAnalysisResult {

    private final ProjectStatistics projectStatistics =
            new ProjectStatistics();

    private final SpringStatistics springStatistics =
            new SpringStatistics();

    private final DependencyGraph dependencyGraph =
            new DependencyGraph();

    public ProjectStatistics getProjectStatistics() {
        return projectStatistics;
    }

    public SpringStatistics getSpringStatistics() {
        return springStatistics;
    }

    public DependencyGraph getDependencyGraph() {
        return dependencyGraph;
    }

    @Override
    public String toString() {

        StringBuilder builder =
                new StringBuilder();

        builder.append("""
                ======================================
                   AI DEV COPILOT PROJECT ANALYSIS
                ======================================

                """);

        builder.append("""
                Project Statistics
                ------------------
                """);

        builder.append(String.format(
                """
                Java Files       : %d
                Packages         : %d
                Classes          : %d
                Interfaces       : %d
                Records          : %d
                Enums            : %d

                """,
                projectStatistics.getJavaFiles(),
                projectStatistics.getPackages(),
                projectStatistics.getClasses(),
                projectStatistics.getInterfaces(),
                projectStatistics.getRecords(),
                projectStatistics.getEnums()
        ));

        builder.append("""
                Spring Components
                ------------------
                """);

        builder.append(String.format(
                """
                Controllers      : %d
                Rest Controllers : %d
                Services         : %d
                Repositories     : %d
                Entities         : %d
                Components       : %d
                Configurations   : %d

                """,
                springStatistics.getControllers(),
                springStatistics.getRestControllers(),
                springStatistics.getServices(),
                springStatistics.getRepositories(),
                springStatistics.getEntities(),
                springStatistics.getComponents(),
                springStatistics.getConfigurations()
        ));

        builder.append("""
                Dependencies
                ------------------
                """);

        if (dependencyGraph.getEdges().isEmpty()) {

            builder.append("No dependencies found.\n");

        } else {

            dependencyGraph.getEdges()
                    .forEach(edge ->
                            builder.append(edge.getFrom())
                                    .append(" -> ")
                                    .append(edge.getTo())
                                    .append("\n"));

        }

        return builder.toString();

    }

}