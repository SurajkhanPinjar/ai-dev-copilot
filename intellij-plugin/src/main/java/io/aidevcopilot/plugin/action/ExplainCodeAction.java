package io.aidevcopilot.plugin.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import io.aidevcopilot.plugin.service.PluginChatService;
import io.aidevcopilot.plugin.util.SelectedCodeUtil;

import javax.swing.*;

public class ExplainCodeAction extends AnAction {

    private final PluginChatService service =
            new PluginChatService();

    @Override
    public void actionPerformed(AnActionEvent event) {

        Editor editor = event.getData(CommonDataKeys.EDITOR);

        if (editor == null) {
            return;
        }

        String code = SelectedCodeUtil.getSelectedCode(editor);

        if (code == null || code.isBlank()) {

            JOptionPane.showMessageDialog(
                    null,
                    "Please select some code.",
                    "AI Dev Copilot",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        SwingWorker<String, Void> worker = new SwingWorker<>() {

            @Override
            protected String doInBackground() throws Exception {

                return service.executeTask(
                        "EXPLAIN_CODE",
                        code
                );
            }

            @Override
            protected void done() {

                try {

                    JOptionPane.showMessageDialog(
                            null,
                            get(),
                            "AI Explanation",
                            JOptionPane.INFORMATION_MESSAGE
                    );

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

        Editor editor = event.getData(CommonDataKeys.EDITOR);

        event.getPresentation().setEnabledAndVisible(
                editor != null &&
                        editor.getSelectionModel().hasSelection()
        );
    }
}