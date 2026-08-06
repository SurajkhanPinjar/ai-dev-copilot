package io.aidevcopilot.plugin.project.util;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;

public final class PsiUtils {

    private PsiUtils() {
    }

    public static PsiFile getPsiFile(
            Project project,
            VirtualFile file
    ) {

        if (project == null || file == null) {
            return null;
        }

        return PsiManager.getInstance(project)
                .findFile(file);

    }

}