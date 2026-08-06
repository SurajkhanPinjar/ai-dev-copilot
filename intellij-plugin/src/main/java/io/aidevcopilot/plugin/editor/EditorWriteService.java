package io.aidevcopilot.plugin.editor;

import io.aidevcopilot.plugin.notification.NotificationService;
import com.intellij.openapi.editor.Editor;

public final class EditorWriteService {

    private EditorWriteService() {
    }

    /**
     * Applies AI generated code to the editor.
     */
    public static void apply(
            Editor editor,
            String generatedCode
    ) {

        if (!isValid(editor, generatedCode)) {
            return;
        }

        EditorCodeReplacer.replaceSelection(
                editor,
                generatedCode
        );

        CodeFormatter.format(
                editor
        );

        ImportOptimizer.optimize(
                editor
        );

        NotificationService.success(
                "AI changes applied successfully."
        );

    }

    private static boolean isValid(
            Editor editor,
            String generatedCode
    ) {

        return editor != null
                && generatedCode != null
                && !generatedCode.isBlank();

    }

}