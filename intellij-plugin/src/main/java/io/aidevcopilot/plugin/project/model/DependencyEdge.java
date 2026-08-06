package io.aidevcopilot.plugin.project.model;

public class DependencyEdge {

    private String from;

    private String to;

    public String getFrom() {
        return from;
    }

    public void setFrom(
            String from
    ) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(
            String to
    ) {
        this.to = to;
    }

}