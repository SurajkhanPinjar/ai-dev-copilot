package io.aidevcopilot.plugin.action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Editor;
import io.aidevcopilot.plugin.editor.EditorPreviewDialog;
import io.aidevcopilot.plugin.toolwindow.ToolWindowManager;

import javax.swing.*;

public abstract class GenerationAction
        extends CodeAction {

    @Override
    protected void beforeExecution(
            AnActionEvent event
    ) {

        ToolWindowManager.setTask(
                getTask().getDisplayName()
        );

        ToolWindowManager.setStatus(
                "🟡 Generating..."
        );

        ToolWindowManager.clearResponse();

    }

    @Override
    protected void onSuccess(
            Editor editor,
            String originalCode,
            String generatedCode
    ) {

        ToolWindowManager.showResponse(
                generatedCode
        );

        ToolWindowManager.setStatus(
                "🟢 Generated"
        );

        // Temporary preview dialog.
        // Later this will be replaced by
        // IntelliJ Merge/Diff Viewer with Apply support.
        EditorPreviewDialog.show(
                null,
                editor,
                generatedCode
        );

    }

    @Override
    protected void onFailure(
            Exception exception
    ) {

        ToolWindowManager.setStatus(
                "🔴 Error"
        );

        JOptionPane.showMessageDialog(
                null,
                exception.getMessage(),
                "AI Dev Copilot",
                JOptionPane.ERROR_MESSAGE
        );

    }

}