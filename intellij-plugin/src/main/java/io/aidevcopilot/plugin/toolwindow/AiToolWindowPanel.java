package io.aidevcopilot.plugin.toolwindow;

import javax.swing.*;
import java.awt.*;

public class AiToolWindowPanel extends JPanel {

    private final JTextArea outputArea;

    public AiToolWindowPanel() {

        setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel(
                "🤖 AI Dev Copilot",
                SwingConstants.CENTER
        );

        title.setFont(
                title.getFont().deriveFont(Font.BOLD, 20f)
        );

        outputArea = new JTextArea();

        outputArea.setEditable(false);

        outputArea.setLineWrap(true);

        outputArea.setWrapStyleWord(true);

        outputArea.setText("""
                Welcome to AI Dev Copilot!

                Backend Status : Not Connected

                Version : 1.0.0

                Ready 🚀
                """);

        add(title, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
    }

    public void setText(String text) {
        outputArea.setText(text);
    }
}