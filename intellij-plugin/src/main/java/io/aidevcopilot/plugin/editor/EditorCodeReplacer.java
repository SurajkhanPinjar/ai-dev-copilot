package io.aidevcopilot.plugin.editor;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;

public final class EditorCodeReplacer {

    private EditorCodeReplacer() {
    }

    public static void replaceSelection(
            Editor editor,
            String newCode
    ) {

        if (editor == null || newCode == null) {
            return;
        }

        SelectionModel selectionModel =
                editor.getSelectionModel();

        if (!selectionModel.hasSelection()) {
            return;
        }

        Document document =
                editor.getDocument();

        int start =
                selectionModel.getSelectionStart();

        int end =
                selectionModel.getSelectionEnd();

        WriteCommandAction.runWriteCommandAction(
                editor.getProject(),
                () -> {

                    document.replaceString(
                            start,
                            end,
                            newCode
                    );

                    selectionModel.removeSelection();

                }
        );

    }

}