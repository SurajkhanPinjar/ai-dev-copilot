package io.aidevcopilot.plugin.toolwindow.components;

import io.aidevcopilot.plugin.toolwindow.ui.UIConstants;

import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {

    private final JLabel statusLabel;
    private final JLabel taskLabel;
    private final JLabel modelLabel;

    public HeaderPanel() {

        setLayout(new BorderLayout());
        setBorder(UIConstants.PANEL_PADDING);

        //-------------------------
        // Title
        //-------------------------

        JLabel title =
                new JLabel("🤖 AI Dev Copilot");

        title.setFont(UIConstants.TITLE_FONT);

        //-------------------------
        // Status
        //-------------------------

        statusLabel =
                new JLabel("🔴 Disconnected");

        statusLabel.setFont(UIConstants.LABEL_FONT);

        JPanel firstRow =
                new JPanel(new BorderLayout());

        firstRow.add(title, BorderLayout.WEST);
        firstRow.add(statusLabel, BorderLayout.EAST);

        //-------------------------
        // Info Panel
        //-------------------------

        JPanel infoPanel =
                new JPanel();

        infoPanel.setLayout(
                new BoxLayout(
                        infoPanel,
                        BoxLayout.Y_AXIS
                )
        );

        taskLabel =
                new JLabel("Task : Chat");

        taskLabel.setFont(UIConstants.LABEL_FONT);

        modelLabel =
                new JLabel("Model : Mistral (Ollama)");

        modelLabel.setFont(UIConstants.LABEL_FONT);

        infoPanel.add(taskLabel);
        infoPanel.add(Box.createVerticalStrut(4));
        infoPanel.add(modelLabel);

        add(firstRow, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.SOUTH);
    }

    public void setStatus(String status) {
        statusLabel.setText(status);
    }

    public void setTask(String task) {
        taskLabel.setText("Task : " + task);
    }

    public void setModel(String model) {
        modelLabel.setText("Model : " + model);
    }

    public JLabel getStatusLabel() {
        return statusLabel;
    }

    public JLabel getTaskLabel() {
        return taskLabel;
    }

    public JLabel getModelLabel() {
        return modelLabel;
    }
}