package io.aidevcopilot.plugin.project.scope;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;

public class AnalysisContext {

    private final Project project;

    private final VirtualFile root;

    private final AnalysisScope scope;

    public AnalysisContext(
            Project project,
            VirtualFile root,
            AnalysisScope scope
    ) {
        this.project = project;
        this.root = root;
        this.scope = scope;
    }

    public Project getProject() {
        return project;
    }

    public VirtualFile getRoot() {
        return root;
    }

    public AnalysisScope getScope() {
        return scope;
    }

}