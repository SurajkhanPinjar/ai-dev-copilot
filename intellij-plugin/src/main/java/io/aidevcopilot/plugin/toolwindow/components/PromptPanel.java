package io.aidevcopilot.plugin.toolwindow.components;

import io.aidevcopilot.plugin.toolwindow.ui.UIConstants;

import javax.swing.*;
import java.awt.*;

public class PromptPanel extends JPanel {

    private final JTextArea promptArea;

    public PromptPanel() {

        setLayout(new BorderLayout(5,5));

        JLabel label =
                new JLabel("Prompt");

        label.setFont(UIConstants.LABEL_FONT);

        promptArea =
                new JTextArea(6, 50);

        promptArea.setFont(UIConstants.TEXT_FONT);
        promptArea.setLineWrap(true);
        promptArea.setWrapStyleWord(true);

        JScrollPane scroll =
                new JScrollPane(promptArea);

        add(label, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        setBorder(UIConstants.PANEL_PADDING);
    }

    public JTextArea getPromptArea() {
        return promptArea;
    }
}