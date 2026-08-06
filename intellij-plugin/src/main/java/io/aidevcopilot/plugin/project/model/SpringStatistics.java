package io.aidevcopilot.plugin.project.model;

public class SpringStatistics {

    private int controllers;

    private int restControllers;

    private int services;

    private int repositories;

    private int entities;

    private int components;

    private int configurations;

    public int getControllers() {
        return controllers;
    }

    public void setControllers(int controllers) {
        this.controllers = controllers;
    }

    public int getRestControllers() {
        return restControllers;
    }

    public void setRestControllers(int restControllers) {
        this.restControllers = restControllers;
    }

    public int getServices() {
        return services;
    }

    public void setServices(int services) {
        this.services = services;
    }

    public int getRepositories() {
        return repositories;
    }

    public void setRepositories(int repositories) {
        this.repositories = repositories;
    }

    public int getEntities() {
        return entities;
    }

    public void setEntities(int entities) {
        this.entities = entities;
    }

    public int getComponents() {
        return components;
    }

    public void setComponents(int components) {
        this.components = components;
    }

    public int getConfigurations() {
        return configurations;
    }

    public void setConfigurations(int configurations) {
        this.configurations = configurations;
    }
}