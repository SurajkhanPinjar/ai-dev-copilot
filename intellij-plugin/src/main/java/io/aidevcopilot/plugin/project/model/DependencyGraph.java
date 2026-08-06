package io.aidevcopilot.plugin.project.model;

import java.util.ArrayList;
import java.util.List;

public class DependencyGraph {

    private final List<DependencyNode> nodes =
            new ArrayList<>();

    private final List<DependencyEdge> edges =
            new ArrayList<>();

    public List<DependencyNode> getNodes() {
        return nodes;
    }

    public List<DependencyEdge> getEdges() {
        return edges;
    }

}