package io.aidevcopilot.plugin.util;

import com.intellij.openapi.editor.Editor;

public final class SelectedCodeUtil {

    private SelectedCodeUtil() {
    }

    public static String getSelectedCode(Editor editor) {

        if (editor == null) {
            return "";
        }

        return editor.getSelectionModel().getSelectedText();
    }
}