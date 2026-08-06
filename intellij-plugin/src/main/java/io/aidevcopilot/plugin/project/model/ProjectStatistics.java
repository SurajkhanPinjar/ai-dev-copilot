package io.aidevcopilot.plugin.project.model;

public class ProjectStatistics {

    private int javaFiles;

    private int packages;

    private int classes;

    private int interfaces;

    private int enums;

    private int records;

    public int getJavaFiles() {
        return javaFiles;
    }

    public void setJavaFiles(int javaFiles) {
        this.javaFiles = javaFiles;
    }

    public int getPackages() {
        return packages;
    }

    public void setPackages(int packages) {
        this.packages = packages;
    }

    public int getClasses() {
        return classes;
    }

    public void setClasses(int classes) {
        this.classes = classes;
    }

    public int getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(int interfaces) {
        this.interfaces = interfaces;
    }

    public int getEnums() {
        return enums;
    }

    public void setEnums(int enums) {
        this.enums = enums;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }
}