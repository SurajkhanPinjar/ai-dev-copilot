package io.aidevcopilot.plugin.action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Editor;
import io.aidevcopilot.plugin.toolwindow.ToolWindowManager;

import javax.swing.*;

public abstract class AnalysisAction
        extends CodeAction {

    @Override
    protected void beforeExecution(
            AnActionEvent event
    ) {

        ToolWindowManager.setTask(
                getTask().getDisplayName()
        );

        ToolWindowManager.setStatus(
                "🟡 Thinking..."
        );

        ToolWindowManager.clearResponse();

    }

    @Override
    protected void onSuccess(
            Editor editor,
            String originalCode,
            String response
    ) {

        ToolWindowManager.showResponse(
                response
        );

        ToolWindowManager.setStatus(
                "🟢 Connected"
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