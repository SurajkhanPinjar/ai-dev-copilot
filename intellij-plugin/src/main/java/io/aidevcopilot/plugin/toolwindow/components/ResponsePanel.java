package io.aidevcopilot.plugin.toolwindow.components;

import io.aidevcopilot.plugin.toolwindow.ui.UIConstants;

import javax.swing.*;
import java.awt.*;

public class ResponsePanel extends JPanel {

    private final JTextPane responsePane;

    public ResponsePanel() {

        setLayout(new BorderLayout(5,5));

        JLabel label =
                new JLabel("AI Response");

        label.setFont(UIConstants.LABEL_FONT);

        responsePane =
                new JTextPane();

        responsePane.setEditable(false);
        responsePane.setFont(UIConstants.TEXT_FONT);

        JScrollPane scroll =
                new JScrollPane(responsePane);

        add(label, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        setBorder(UIConstants.PANEL_PADDING);
    }

    public JTextPane getResponsePane() {
        return responsePane;
    }
}