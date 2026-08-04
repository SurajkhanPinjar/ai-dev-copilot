package io.aidevcopilot.plugin.toolwindow.components;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    private final JButton askButton;
    private final JButton copyButton;
    private final JButton clearButton;

    public ButtonPanel() {

        setLayout(new FlowLayout(FlowLayout.LEFT));

        askButton =
                new JButton("Ask AI");

        copyButton =
                new JButton("Copy");

        clearButton =
                new JButton("Clear");

        add(askButton);
        add(copyButton);
        add(clearButton);
    }

    public JButton getAskButton() {
        return askButton;
    }

    public JButton getCopyButton() {
        return copyButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }
}