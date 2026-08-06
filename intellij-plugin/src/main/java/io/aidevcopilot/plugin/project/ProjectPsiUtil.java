package io.aidevcopilot.plugin.project;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.PsiManager;

public final class ProjectPsiUtil {

    private ProjectPsiUtil() {
    }

    public static PsiJavaFile getJavaFile(
            Project project,
            VirtualFile file
    ) {

        if (project == null || file == null) {
            return null;
        }

        if (PsiManager.getInstance(project)
                .findFile(file) instanceof PsiJavaFile javaFile) {

            return javaFile;
        }

        return null;
    }
}