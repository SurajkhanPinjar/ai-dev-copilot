package io.aidevcopilot.plugin.project;

public class ProjectSummary {

    private int javaFiles;

    private int packages;

    private int classes;

    private int interfaces;

    private int enums;

    private int records;

    private int controllers;

    private int restControllers;

    private int services;

    private int repositories;

    private int entities;

    private int configurations;

    private int components;

    public int getJavaFiles() {
        return javaFiles;
    }

    public void incrementJavaFiles() {
        javaFiles++;
    }

    public int getPackages() {
        return packages;
    }

    public void incrementPackages() {
        packages++;
    }

    public int getClasses() {
        return classes;
    }

    public void incrementClasses() {
        classes++;
    }

    public int getInterfaces() {
        return interfaces;
    }

    public void incrementInterfaces() {
        interfaces++;
    }

    public int getEnums() {
        return enums;
    }

    public void incrementEnums() {
        enums++;
    }

    public int getRecords() {
        return records;
    }

    public void incrementRecords() {
        records++;
    }

    public int getControllers() {
        return controllers;
    }

    public void incrementControllers() {
        controllers++;
    }

    public int getRestControllers() {
        return restControllers;
    }

    public void incrementRestControllers() {
        restControllers++;
    }

    public int getServices() {
        return services;
    }

    public void incrementServices() {
        services++;
    }

    public int getRepositories() {
        return repositories;
    }

    public void incrementRepositories() {
        repositories++;
    }

    public int getEntities() {
        return entities;
    }

    public void incrementEntities() {
        entities++;
    }

    public int getConfigurations() {
        return configurations;
    }

    public void incrementConfigurations() {
        configurations++;
    }

    public int getComponents() {
        return components;
    }

    public void incrementComponents() {
        components++;
    }

    @Override
    public String toString() {

        return """
                ===============================
                PROJECT SUMMARY
                ===============================

                Java Files      : %d
                Packages        : %d

                Classes         : %d
                Interfaces      : %d
                Records         : %d
                Enums           : %d

                Controllers     : %d
                RestControllers : %d
                Services        : %d
                Repositories    : %d
                Entities        : %d
                Components      : %d
                Configurations  : %d
                """.formatted(
                javaFiles,
                packages,
                classes,
                interfaces,
                records,
                enums,
                controllers,
                restControllers,
                services,
                repositories,
                entities,
                components,
                configurations
        );
    }
}