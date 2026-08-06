package io.aidevcopilot.plugin.project.util;

import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiJavaFile;

public final class PsiCapabilityChecker {

    private PsiCapabilityChecker() {
    }

    public static boolean isAvailable() {

        Class<?> a = PsiClass.class;
        Class<?> b = PsiJavaFile.class;

        return a != null && b != null;

    }

}