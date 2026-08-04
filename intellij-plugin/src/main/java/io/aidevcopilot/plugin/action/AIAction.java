package io.aidevcopilot.plugin.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import io.aidevcopilot.plugin.dto.AITask;
import io.aidevcopilot.plugin.service.PluginChatService;
import io.aidevcopilot.plugin.toolwindow.ToolWindowManager;
import io.aidevcopilot.plugin.util.SelectedCodeUtil;

import javax.swing.*;

public abstract class AIAction extends AnAction {

    private final PluginChatService chatService =
            new PluginChatService();

    @Override
    public void actionPerformed(AnActionEvent event) {

        Editor editor = event.getData(CommonDataKeys.EDITOR);

        if (editor == null) {
            return;
        }

        String input = SelectedCodeUtil.getSelectedCode(editor);

        if (input == null || input.isBlank()) {

            JOptionPane.showMessageDialog(
                    null,
                    "Please select some code.",
                    "AI Dev Copilot",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        SwingWorker<String, Void> worker =
                new SwingWorker<>() {

                    @Override
                    protected String doInBackground() throws Exception {

                        return chatService.executeTask(
                                getTask(),
                                input
                        );
                    }

                    @Override
                    protected void done() {

                        try {

                            ToolWindowManager.showResponse(get());

                        } catch (Exception ex) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    ex.getMessage(),
                                    "AI Dev Copilot",
                                    JOptionPane.ERROR_MESSAGE
                            );

                            ex.printStackTrace();
                        }
                    }
                };

        worker.execute();
    }

    @Override
    public void update(AnActionEvent event) {

        Editor editor =
                event.getData(CommonDataKeys.EDITOR);

        event.getPresentation().setEnabledAndVisible(
                editor != null &&
                        editor.getSelectionModel().hasSelection()
        );
    }

    protected void showResult(String response) {

        JOptionPane.showMessageDialog(
                null,
                response,
                "AI Dev Copilot",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    protected abstract AITask getTask();
}