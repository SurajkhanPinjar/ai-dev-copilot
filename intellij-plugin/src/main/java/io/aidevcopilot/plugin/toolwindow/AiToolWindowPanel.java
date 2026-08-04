package io.aidevcopilot.plugin.toolwindow;

import io.aidevcopilot.plugin.client.AiBackendClient;
import io.aidevcopilot.plugin.toolwindow.components.ButtonPanel;
import io.aidevcopilot.plugin.toolwindow.components.HeaderPanel;
import io.aidevcopilot.plugin.toolwindow.components.PromptPanel;
import io.aidevcopilot.plugin.toolwindow.components.ResponsePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class AiToolWindowPanel extends JPanel {

    private final HeaderPanel headerPanel;
    private final PromptPanel promptPanel;
    private final ResponsePanel responsePanel;
    private final ButtonPanel buttonPanel;

    private final AiBackendClient backendClient =
            new AiBackendClient();

    public AiToolWindowPanel() {

        setLayout(new BorderLayout());

        headerPanel = new HeaderPanel();
        promptPanel = new PromptPanel();
        responsePanel = new ResponsePanel();
        buttonPanel = new ButtonPanel();

        JPanel topPanel = new JPanel(new BorderLayout());

        topPanel.add(headerPanel, BorderLayout.NORTH);
        topPanel.add(promptPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        JSplitPane splitPane =
                new JSplitPane(
                        JSplitPane.VERTICAL_SPLIT,
                        topPanel,
                        responsePanel
                );

        splitPane.setResizeWeight(0.35);
        splitPane.setContinuousLayout(true);
        splitPane.setOneTouchExpandable(true);

        add(splitPane, BorderLayout.CENTER);

        ToolWindowManager.register(this);

        registerListeners();
    }

    private void registerListeners() {

        buttonPanel.getAskButton().addActionListener(e -> askAI());

        buttonPanel.getClearButton().addActionListener(e -> {

            ToolWindowManager.setPrompt("");
            ToolWindowManager.clearResponse();

        });

        buttonPanel.getCopyButton().addActionListener(e -> {

            StringSelection selection =
                    new StringSelection(
                            responsePanel
                                    .getResponsePane()
                                    .getText()
                    );

            Toolkit.getDefaultToolkit()
                    .getSystemClipboard()
                    .setContents(selection, null);

            JOptionPane.showMessageDialog(
                    this,
                    "Copied to clipboard.",
                    "AI Dev Copilot",
                    JOptionPane.INFORMATION_MESSAGE
            );

        });
    }

    private void askAI() {

        String prompt =
                promptPanel
                        .getPromptArea()
                        .getText()
                        .trim();

        if (prompt.isBlank()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a prompt.",
                    "AI Dev Copilot",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        ToolWindowManager.setTask("Chat");
        ToolWindowManager.setStatus("🟡 Thinking...");

        promptPanel.getPromptArea().setEditable(false);
        buttonPanel.getAskButton().setEnabled(false);

        new SwingWorker<String, Void>() {

            @Override
            protected String doInBackground() throws Exception {

                return backendClient.ask(prompt);

            }

            @Override
            protected void done() {

                try {

                    String response = get();

                    ToolWindowManager.showResponse(response);
                    ToolWindowManager.setStatus("🟢 Connected");

                    responsePanel
                            .getResponsePane()
                            .setCaretPosition(0);

                } catch (Exception ex) {

                    ToolWindowManager.showResponse(ex.getMessage());
                    ToolWindowManager.setStatus("🔴 Error");

                } finally {

                    promptPanel
                            .getPromptArea()
                            .setEditable(true);

                    buttonPanel
                            .getAskButton()
                            .setEnabled(true);

                }
            }

        }.execute();
    }

    public PromptPanel getPromptPanel() {
        return promptPanel;
    }

    public ResponsePanel getResponsePanel() {
        return responsePanel;
    }

    public HeaderPanel getHeaderPanel() {
        return headerPanel;
    }

    public ButtonPanel getButtonPanel() {
        return buttonPanel;
    }

    public void setResponse(String response) {

        responsePanel
                .getResponsePane()
                .setText(response);

        responsePanel
                .getResponsePane()
                .setCaretPosition(0);
    }

    public void setStatus(String status) {

        headerPanel
                .getStatusLabel()
                .setText(status);
    }

    public void setPrompt(String prompt) {

        promptPanel
                .getPromptArea()
                .setText(prompt);
    }

    public void clearResponse() {

        responsePanel
                .getResponsePane()
                .setText("");
    }

    public void setTask(String task) {

        headerPanel.setTask(task);
    }

    public void setModel(String model) {

        headerPanel.setModel(model);

    }
}