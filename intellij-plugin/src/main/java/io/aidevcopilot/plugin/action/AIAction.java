package io.aidevcopilot.plugin.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Editor;
import io.aidevcopilot.plugin.dto.AITask;
import io.aidevcopilot.plugin.service.PluginChatService;

import javax.swing.*;

public abstract class AIAction extends AnAction {

    private final PluginChatService chatService =
            new PluginChatService();

    @Override
    public final void actionPerformed(
            AnActionEvent event
    ) {

        try {

            beforeExecution(event);

            Editor editor =
                    getEditor(event);

            final String input =
                    getInput(event);

            SwingWorker<String, Void> worker =
                    new SwingWorker<>() {

                        @Override
                        protected String doInBackground()
                                throws Exception {

                            return chatService.executeTask(
                                    getTask(),
                                    input
                            );

                        }

                        @Override
                        protected void done() {

                            try {

                                String response =
                                        get();

                                onSuccess(
                                        editor,
                                        input,
                                        response
                                );

                            } catch (Exception ex) {

                                onFailure(ex);

                            } finally {

                                afterExecution();

                            }

                        }

                    };

            worker.execute();

        } catch (Exception ex) {

            onFailure(ex);

        }

    }

    protected void beforeExecution(
            AnActionEvent event
    ) {
    }

    protected void afterExecution() {
    }

    protected abstract AITask getTask();

    protected abstract String getInput(
            AnActionEvent event
    );

    protected abstract Editor getEditor(
            AnActionEvent event
    );

    /**
     * Called when AI request succeeds.
     */
    protected abstract void onSuccess(
            Editor editor,
            String originalCode,
            String response
    );

    protected void onFailure(
            Exception exception
    ) {

        JOptionPane.showMessageDialog(
                null,
                exception.getMessage(),
                "AI Dev Copilot",
                JOptionPane.ERROR_MESSAGE
        );

    }

}