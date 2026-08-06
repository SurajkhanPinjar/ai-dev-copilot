package io.aidevcopilot.plugin.project.model;

public class ProjectAnalysisResult {

    private final ProjectStatistics projectStatistics =
            new ProjectStatistics();

    private final SpringStatistics springStatistics =
            new SpringStatistics();

    public ProjectStatistics getProjectStatistics() {
        return projectStatistics;
    }

    public SpringStatistics getSpringStatistics() {
        return springStatistics;
    }

    @Override
    public String toString() {

        return """
                ======================================
                   AI DEV COPILOT PROJECT ANALYSIS
                ======================================

                Project Statistics
                ------------------
                Java Files     : %d
                Packages       : %d
                Classes        : %d
                Interfaces     : %d
                Records        : %d
                Enums          : %d

                Spring Components
                ------------------
                Controllers    : %d
                Rest Controllers : %d
                Services       : %d
                Repositories   : %d
                Entities       : %d
                Components     : %d
                Configurations : %d
                """.formatted(

                projectStatistics.getJavaFiles(),
                projectStatistics.getPackages(),
                projectStatistics.getClasses(),
                projectStatistics.getInterfaces(),
                projectStatistics.getRecords(),
                projectStatistics.getEnums(),

                springStatistics.getControllers(),
                springStatistics.getRestControllers(),
                springStatistics.getServices(),
                springStatistics.getRepositories(),
                springStatistics.getEntities(),
                springStatistics.getComponents(),
                springStatistics.getConfigurations()

        );

    }

}