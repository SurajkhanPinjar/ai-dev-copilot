package io.aidevcopilot.plugin.editor;

import com.intellij.openapi.editor.Editor;

import javax.swing.*;
import java.awt.*;

public final class EditorPreviewDialog {

    private static final String TITLE = "AI Suggested Changes";

    private static final int WIDTH = 950;

    private static final int HEIGHT = 650;

    private EditorPreviewDialog() {
    }

    public static void show(
            Component parent,
            Editor editor,
            String generatedCode
    ) {

        if (!isValid(editor, generatedCode)) {
            return;
        }

        JScrollPane scrollPane =
                createScrollPane(generatedCode);

        int option =
                JOptionPane.showConfirmDialog(
                        parent,
                        scrollPane,
                        TITLE,
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE
                );

        if (option == JOptionPane.OK_OPTION) {

            EditorWriteService.apply(
                    editor,
                    generatedCode
            );

        }

    }

    private static boolean isValid(
            Editor editor,
            String generatedCode
    ) {

        return editor != null
                && generatedCode != null
                && !generatedCode.isBlank();

    }

    private static JScrollPane createScrollPane(
            String generatedCode
    ) {

        JTextArea previewArea =
                createPreviewArea(generatedCode);

        JScrollPane scrollPane =
                new JScrollPane(previewArea);

        scrollPane.setPreferredSize(
                new Dimension(WIDTH, HEIGHT)
        );

        scrollPane.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED
        );

        scrollPane.setHorizontalScrollBarPolicy(
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );

        return scrollPane;

    }

    private static JTextArea createPreviewArea(
            String generatedCode
    ) {

        JTextArea previewArea =
                new JTextArea(generatedCode);

        previewArea.setEditable(false);

        previewArea.setCaretPosition(0);

        previewArea.setLineWrap(false);

        previewArea.setWrapStyleWord(false);

        previewArea.setFont(
                new Font(
                        Font.MONOSPACED,
                        Font.PLAIN,
                        14
                )
        );

        previewArea.setTabSize(4);

        return previewArea;

    }

}