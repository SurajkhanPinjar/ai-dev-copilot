package io.aidevcopilot.plugin.toolwindow.ui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public final class UIConstants {

    private UIConstants() {
    }

    public static final Font TITLE_FONT =
            new Font(Font.SANS_SERIF, Font.BOLD, 22);

    public static final Font LABEL_FONT =
            new Font(Font.SANS_SERIF, Font.BOLD, 13);

    public static final Font TEXT_FONT =
            new Font(Font.SANS_SERIF, Font.PLAIN, 14);

    public static final Insets BUTTON_INSETS =
            new Insets(8, 18, 8, 18);

    public static final Border PANEL_PADDING =
            new EmptyBorder(10, 10, 10, 10);
}