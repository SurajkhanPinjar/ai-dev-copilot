package io.aidevcopilot.plugin.project.model;

public class DependencyNode {

    private String className;

    private String packageName;

    private String type;

    public String getClassName() {
        return className;
    }

    public void setClassName(
            String className
    ) {
        this.className = className;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(
            String packageName
    ) {
        this.packageName = packageName;
    }

    public String getType() {
        return type;
    }

    public void setType(
            String type
    ) {
        this.type = type;
    }

}