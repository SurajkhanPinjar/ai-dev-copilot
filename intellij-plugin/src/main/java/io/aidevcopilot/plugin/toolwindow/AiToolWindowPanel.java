package io.aidevcopilot.plugin.toolwindow;

import io.aidevcopilot.plugin.service.PluginChatService;

import javax.swing.*;
import java.awt.*;

public class AiToolWindowPanel extends JPanel {

    private final JTextArea questionArea;
    private final JTextArea answerArea;
    private final JButton askButton;
    private final JLabel statusLabel;

    private final PluginChatService chatService =
            new PluginChatService();

    public AiToolWindowPanel() {

        setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel(
                "🤖 AI Dev Copilot",
                SwingConstants.CENTER
        );

        title.setFont(
                title.getFont().deriveFont(Font.BOLD, 20f)
        );

        statusLabel = new JLabel("Backend Status : 🔴 Disconnected");

        questionArea = new JTextArea(5, 50);
        questionArea.setLineWrap(true);
        questionArea.setWrapStyleWord(true);

        answerArea = new JTextArea();
        answerArea.setEditable(false);
        answerArea.setLineWrap(true);
        answerArea.setWrapStyleWord(true);

        askButton = new JButton("Ask AI");

        JPanel top = new JPanel(new BorderLayout());

        top.add(title, BorderLayout.NORTH);
        top.add(statusLabel, BorderLayout.SOUTH);

        JPanel center = new JPanel(new BorderLayout(10, 10));

        center.add(
                new JScrollPane(questionArea),
                BorderLayout.NORTH
        );

        center.add(
                askButton,
                BorderLayout.CENTER
        );

        center.add(
                new JScrollPane(answerArea),
                BorderLayout.SOUTH
        );

        add(top, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);

        askButton.addActionListener(event -> askQuestion());
    }

    private void askQuestion() {

        String question = questionArea.getText().trim();

        if (question.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a question.",
                    "Validation",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        askButton.setEnabled(false);

        statusLabel.setText("Backend Status : 🟡 Asking...");

        answerArea.setText("Thinking...");

        SwingWorker<String, Void> worker = new SwingWorker<>() {

            @Override
            protected String doInBackground() throws Exception {

                return chatService.ask(question);
            }

            @Override
            protected void done() {

                try {

                    String answer = get();

                    answerArea.setText(answer);

                    statusLabel.setText(
                            "Backend Status : 🟢 Connected"
                    );

                } catch (Exception ex) {

                    answerArea.setText(
                            """
                            Unable to connect to AI Backend.
                            
                            Please ensure:
                            • Spring Boot backend is running
                            • Ollama is running
                            • Backend is listening on port 8080
                            """
                    );

                    statusLabel.setText(
                            "Backend Status : 🔴 Error"
                    );

                    ex.printStackTrace();
                }

                askButton.setEnabled(true);
            }
        };

        worker.execute();
    }

    public JButton getAskButton() {
        return askButton;
    }

    public JTextArea getQuestionArea() {
        return questionArea;
    }

    public JTextArea getAnswerArea() {
        return answerArea;
    }

    public JLabel getStatusLabel() {
        return statusLabel;
    }
}