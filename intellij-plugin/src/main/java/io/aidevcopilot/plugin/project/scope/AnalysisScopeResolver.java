package io.aidevcopilot.plugin.project.scope;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.vfs.VirtualFile;

public class AnalysisScopeResolver {

    public AnalysisContext resolve(
            AnActionEvent event
    ) {

        Project project =
                event.getProject();

        if (project == null) {
            throw new IllegalArgumentException(
                    "No project found."
            );
        }

        VirtualFile selected =
                event.getData(
                        CommonDataKeys.VIRTUAL_FILE
                );

        // Nothing selected → analyze whole project
        if (selected == null) {

            return new AnalysisContext(
                    project,
                    project.getBaseDir(),
                    AnalysisScope.PROJECT
            );

        }

        // Java file selected
        if (!selected.isDirectory()) {

            return new AnalysisContext(
                    project,
                    selected,
                    AnalysisScope.FILE
            );

        }

        // Directory selected
        Module module =
                ModuleUtilCore.findModuleForFile(
                        selected,
                        project
                );

        if (module != null) {

            for (VirtualFile root :
                    ModuleRootManager.getInstance(module)
                            .getContentRoots()) {

                if (root.equals(selected)) {

                    return new AnalysisContext(
                            project,
                            selected,
                            AnalysisScope.MODULE
                    );

                }

            }

        }

        // Otherwise treat it as a package/folder
        return new AnalysisContext(
                project,
                selected,
                AnalysisScope.PACKAGE
        );

    }

}